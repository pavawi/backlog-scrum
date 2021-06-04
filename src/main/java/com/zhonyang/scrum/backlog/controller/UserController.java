package com.zhonyang.scrum.backlog.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhonyang.scrum.backlog.common.exception.BusinessException;
import com.zhonyang.scrum.backlog.entity.User;
import com.zhonyang.scrum.backlog.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author alan
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @PostMapping("doLogin")
    @ApiOperation("doLogin")
    public SaTokenInfo doLogin(String username, String password) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, username));
        if (ObjectUtil.isNotNull(user)) {
            if (SecureUtil.sha1(password).equals(user.getPassword())) {
                StpUtil.setLoginId(user.getId());
                SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
                log.info("{}:{}", saTokenInfo.getTokenName(), saTokenInfo.getTokenValue());
                return saTokenInfo;
            }
        }
        throw new BusinessException("用户名或密码错误");
    }

    @GetMapping("isLogin")
    @ApiOperation("isLogin")
    public Boolean isLogin() {
        return StpUtil.getTokenInfo().isLogin;
    }

}
