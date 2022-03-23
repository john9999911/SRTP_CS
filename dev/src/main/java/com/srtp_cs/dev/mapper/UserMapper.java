package com.srtp_cs.dev.mapper;


import com.srtp_cs.dev.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User selectUserByUid(int uid);
    User selectUserByMail(String mail);
    List<User> selectUserByName(String name);
    List<User> selectAllUsers();
    void insertUser(String mail, String name, String pwd);
    void updateUser(User user);
    void deleteUser(int uid);
}
