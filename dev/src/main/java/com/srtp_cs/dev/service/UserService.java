package com.srtp_cs.dev.service;
//

import com.srtp_cs.dev.entity.User;

import java.util.List;

//
//import java.util.Collection;
//
public interface UserService {

    User selectUserByUid(int uid);

    List<User> selectUserByName(String name);

    User selectUserByMail(String mail);


    List<User> selectAllUsers();
//
    void insertUser(String mail, String name, String password);
//
    void updateUser(User user);
//
    void deleteUser(int uid);

}
