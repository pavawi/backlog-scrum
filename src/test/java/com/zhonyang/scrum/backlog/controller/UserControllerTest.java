package com.zhonyang.scrum.backlog.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void doLogin() {
        System.out.println(SecureUtil.sha1("123456"));
    }

    @Test
    void isLogin() {
    }
}