package com.zhonyang.scrum.backlog.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String email;
}
