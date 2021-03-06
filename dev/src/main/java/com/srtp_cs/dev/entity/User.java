package com.srtp_cs.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String name;
    private String pwd;
    private String mail;
}
