package com.zhonyang.scrum.backlog.controller;

import com.zhonyang.scrum.backlog.common.annotation.IgnoreResponseAdvice;
import com.zhonyang.scrum.backlog.common.exception.category.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 类忽略拦截测试
 * @author: alan
 * @date: 2021/6/3 22:16
 */
@RestController
@IgnoreResponseAdvice(errorDispose = false)
@RequestMapping("ignor")
public class IgnoreResponseAdviceController {

    /**
     * 全局异常处理
     */
    @GetMapping("error")
    @ApiOperation("error")
    public String error() {
        throw new BusinessException(0, "异常演示");
    }

    /**
     * 全局异常处理
     */
    @GetMapping("error1")
    @ApiOperation("error1")
    public String error1() {
        throw new BusinessException(0, "异常演示");
    }

}
