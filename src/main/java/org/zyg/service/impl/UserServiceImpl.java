package org.zyg.service.impl;

import org.springframework.stereotype.Service;
import org.zyg.dao.UserMapper;
import org.zyg.domain.User;
import org.zyg.service.UserService;

import javax.annotation.Resource;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userMapper")
    private UserMapper userMapper;


    @Override
    public User queryUser(String userName, String userPass) {
        return userMapper.queryUser(userName, userPass);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }
}
