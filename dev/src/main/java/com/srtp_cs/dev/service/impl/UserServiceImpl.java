package com.srtp_cs.dev.service.impl;

import com.srtp_cs.dev.entity.User;
import com.srtp_cs.dev.mapper.UserMapper;
import com.srtp_cs.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUid(int uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    public User selectUserByMail(String mail) {
        return userMapper.selectUserByMail(mail);
    }

    @Override
    public List<User> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public void insertUser(String mail, String name, String pwd) {
        userMapper.insertUser(mail, name, pwd);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int uid) {
        userMapper.deleteUser(uid);
    }


}