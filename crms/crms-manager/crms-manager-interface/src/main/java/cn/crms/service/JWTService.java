package cn.crms.service;

import cn.crms.pojo.JwtLogin;
import com.auth0.jwt.JWTExpiredException;
import com.auth0.jwt.JWTVerifyException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * @author zhous
 * @create 2019-04-03 14:30
 */
public interface JWTService {
    /**
     * 签发token
     *
     * @param object 放入封装的jwtLogin对象
     * @return String 签发的jwtToken
     */
    String createToken(JwtLogin object) throws JsonGenerationException, JsonMappingException, IOException;

    /**
     * 检测token
     *
     * @param jwtToken 登陆签发的token
     * @return 解密jwtToken的jwtLogin对象
     */
    JwtLogin checkToken(String jwtToken) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException,
            SignatureException, IOException, JWTVerifyException, JWTExpiredException;

    /**
     * 获取过期时间，用于声名jwtLogin对象
     *
     * @return properties中注入的过期时间
     */
    Long getTokenExpity();
}
