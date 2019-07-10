package cn.crms.controller;

import cn.crms.pojo.User;
import cn.crms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhous
 * @create 2019-02-19 21:58
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/select")
    public List<User> selectAllUser() {
        List<User> users = userService.selectAllUser();
        return users;
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        User login = userService.login(user);
        if (login != null) {
            session.setAttribute("user",login);
            return "1";
        } else {
            return "0";
        }

    }

}
