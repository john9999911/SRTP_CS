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


//    Collection<User> selectAllUsers();
//
    void insertUser(User user);
//
    void updateUser(User user);
//
    void deleteUser(int uid);

    Boolean login(String mail, String password);

    boolean register(User user);
}
