package cn.crms.service.impl;

import cn.crms.pojo.JwtLogin;
import cn.crms.service.JWTService;
import com.auth0.jwt.JWTExpiredException;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.com.fasterxml.jackson.core.JsonGenerationException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.JsonMappingException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhous
 * @create 2019-04-03 14:33
 */
@Service("jwtServiceImpl")
public class JWTServiceImpl implements JWTService {
    /** Token秘钥*/
    private String SECRET = "123456!@#";
    /** Token有效期(秒)，7天 */
    private Long TOKEN_EXPITY = 60 * 60 * 24 * 7L;

    private static final String EXP = "exp";
    private static final String PAYLOAD = "payload";

    // 加密
    public String createToken(JwtLogin object) throws JsonGenerationException, JsonMappingException, IOException {
        // 加密工具类可以按照业务需求修改
        final JWTSigner signer = new JWTSigner(SECRET);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(object);

        final Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(PAYLOAD, jsonString);
        claims.put(EXP, object.getExp());// token验证机制的有效期
        return signer.sign(claims);
    }

    // 解密
    public JwtLogin checkToken(String jwtToken) throws InvalidKeyException, NoSuchAlgorithmException,
            IllegalStateException, SignatureException, IOException, JWTVerifyException {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String, Object> map = verifier.verify(jwtToken);
            if (map.containsKey(EXP) && map.containsKey(PAYLOAD)) {
                String str = (String) map.get(PAYLOAD);
                ObjectMapper objectMapper = new ObjectMapper();
                JwtLogin jwtLogin = objectMapper.readValue(str, JwtLogin.class);
                return jwtLogin;
            }
        } catch (JWTExpiredException e) {
            throw e;
        }
        return null;

    }

    // 获取过期时间
    @Override
    public Long getTokenExpity() {
        return TOKEN_EXPITY;
    }

}
