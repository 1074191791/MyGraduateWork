package cn.crms.Intercepter;

import cn.crms.pojo.JwtLogin;
import cn.crms.service.JWTService;
import com.auth0.jwt.JWTExpiredException;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.com.fasterxml.jackson.core.JsonParseException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.InvalidKeyException;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Resource
    private JWTService jwtService;

    /**
     * 进行JWT校验
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 标注@NoAuthAnnotation的方法不需要进行拦截
        try {
            HandlerMethod method = (HandlerMethod) handler;
            NoAuthAnnotation noAuth = method.getMethodAnnotation(NoAuthAnnotation.class);
            if (null != noAuth) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        String headerToken = "";
        String headerUid = "";
        /*String headerToken = request.getHeader("auth_token"); // header请求入参
        String headerUid = request.getHeader("uid");// header请求入参*/
        Cookie[] cookies = request.getCookies();// header请求入参
        for (Cookie cookie : cookies) {
            if("auth_token".equals(cookie.getName())) {
                headerToken = cookie.getValue();
            }
            if("uid".equals(cookie.getName())) {
                headerUid = cookie.getValue();
            }
        }

        // 非空校验
        if (StringUtils.isEmpty(headerToken)) {
            return false;
        }
        if (StringUtils.isEmpty(headerUid)) {
            return false;
        }
        // jwt校验
        JwtLogin login = null;
        try {
            login = jwtService.checkToken(headerToken);
        } catch (JsonParseException e) {
            // e.printStackTrace();
            return false;
        } catch (JWTExpiredException e) {
            // e.printStackTrace();
            return false;
        } catch (InvalidKeyException e) {
            // e.printStackTrace();
            LOGGER.error(e.getMessage());
        } catch (JWTVerifyException e) {
            // e.printStackTrace();
            LOGGER.info(e.getMessage());
        }

        if (null == login || !StringUtils.equals(login.getUid(), headerUid)) { // 为防止误入uid, 解密token后的uid与header中的uid进行匹配
            return false;
        }

        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
