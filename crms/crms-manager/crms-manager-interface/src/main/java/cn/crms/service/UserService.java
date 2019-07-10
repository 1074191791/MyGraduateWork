package cn.crms.service;

import cn.crms.pojo.User;

import java.util.List;

/**
 * @author zhous
 * @create 2019-02-19 22:07
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return 所有用户
     */
    List<User> selectAllUser();

    /**
     * 实现登录功能
     * @param user 登录用户信息
     * @return User对象
     */
    User login(User user);
}
