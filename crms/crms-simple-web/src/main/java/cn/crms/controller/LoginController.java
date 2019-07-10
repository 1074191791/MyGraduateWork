package cn.crms.controller;

import cn.crms.Intercepter.NoAuthAnnotation;
import cn.crms.pojo.JwtLogin;
import cn.crms.pojo.Student;
import cn.crms.service.JWTService;
import cn.crms.service.StudentService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 * @author zhous
 * @create 2019-03-12 15:15
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    StudentService studentService;

    @Resource
    JWTService jwtService;

    @NoAuthAnnotation
    @ResponseBody
    @RequestMapping("/studentLogin")
    public String studentLogin(Student student,String checkcode, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        JwtLogin jwtLogin = new JwtLogin();
        String codeRex = (String)session.getAttribute("code");

        Student record = studentService.studentLogin(student);
        if (record != null && checkcode!= null && codeRex != null && checkcode.equals(codeRex)) {
            Integer status = record.getStatus();
            session.setAttribute("login",record);
            //封装jwtLogin
            jwtLogin.setUid(record.getUid());
            jwtLogin.setExp(System.currentTimeMillis() / 1000L + jwtService.getTokenExpity());
            jwtLogin.setLoginName(record.getUsername());
            jwtLogin.setPassword(record.getPassword());

            String token = null;
            try {
                token = jwtService.createToken(jwtLogin);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 返回JWT生成token，封装到map中
            /*Map<String, Object> result = new HashMap<String, Object>();
            result.put("loginToken", token);// 返回token.
            result.put("userId", record.getUid());// 用户ID
            result.put("exp", jwtLogin.getExp());// 到时时间（设置在properties中）

            Gson gson = new Gson();
            String toJson = gson.toJson(result);*/

            Cookie cookie1 = new Cookie("auth_token",token);
            Cookie cookie2 = new Cookie("uid",record.getUid());
            cookie1.setPath(request.getContextPath()+"/");
            cookie2.setPath(request.getContextPath()+"/");

           /* cookie1.setMaxAge(60*30);
            cookie2.setMaxAge(60*30);*/
            response.addCookie(cookie1);
            response.addCookie(cookie2);

            return "1";
        } else {
            return "0";
        }
    }

}
