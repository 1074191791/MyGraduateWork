package cn.crms.service.impl;

import cn.crms.mapper.UserMapper;
import cn.crms.pojo.User;
import cn.crms.pojo.UserExample;
import cn.crms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhous
 * @create 2019-02-19 22:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {

        UserExample userExample = new UserExample();
        userExample.setDistinct(true);

        List<User> users = userMapper.selectByExample(userExample);
       /*List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setUsername("周硕");
        u1.setPassword("12312312");
        User u2 = new User();
        u2.setUsername("22222");
        u2.setPassword("222222");

        users.add(u1);
        users.add(u2);
        System.out.println(userMapper);*/

        return users;
    }

    @Override
    public User login(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        User result = userMapper.selectByUser(user);
        return result;
    }
}
