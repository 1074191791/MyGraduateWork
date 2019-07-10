package cn.crms.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * JWT组件解析入参出参
 * @author zhous
 * @create 2019-04-03 14:24
 */
public class JwtLogin implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = -6663855178955879830L;

    private String uid; // 用户id

    private String loginName;
    private String password;
    private Long exp; // 有效期

    public JwtLogin() {
        super();
    }

    public JwtLogin(String uid, String loginName, String password, Long exp) {
        this.uid = uid;
        this.loginName = loginName;
        this.password = password;
        this.exp = exp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

}
