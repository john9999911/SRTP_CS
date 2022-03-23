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
    public List<User> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public User selectUserByMail(String mail) {
        return userMapper.selectUserByMail(mail);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int uid) {
        userMapper.deleteUser(uid);
    }

    @Override
    public Boolean login(String mail, String password) {
        User user = userMapper.selectUserByMail(mail);
        if (user == null) {
            return false;
        } else {
            return user.getPwd().equals(password);
        }
    }

    @Override
    public boolean register(User user) {
        if (userMapper.selectUserByMail(user.getMail()) != null) {
            return false;
        } else {
            userMapper.insertUser(user);
            return true;
        }
    }
}