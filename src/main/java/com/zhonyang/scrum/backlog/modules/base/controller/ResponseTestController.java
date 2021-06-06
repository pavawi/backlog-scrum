package com.zhonyang.scrum.backlog.modules.base.controller;

import com.zhonyang.scrum.backlog.common.annotation.IgnoreResponseAdvice;
import com.zhonyang.scrum.backlog.common.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试api返回和异常捕获
 *
 * @author alan
 * @version 1.0
 * @date 2021/6/4 21:12
 */
@RestController
@RequestMapping("/test")
public class ResponseTestController {

    /**
     * 测试 返回为 string类型 值为 不为null
     */
    @GetMapping("/")
    public String test() {
        return "test";
    }

    /**
     * 测试 返回为 String类型 值为 null
     */
    @GetMapping("/null")
    public String testNull() {
        return null;
    }

    /**
     * 测试 返回为 object类型 值为 null
     */
    @GetMapping("/object")
    public Object objectNull() {
        return null;
    }

    /**
     * 测试 返回为 list类型 值为 null
     */
    @GetMapping("/list")
    public List<String> testListNull() {
        return null;
    }

    /**
     * {@link IgnoreResponseAdvice} 使用
     */
    @GetMapping("/ignore")
    @IgnoreResponseAdvice
    public String Ignore() {
        return "Ignore";
    }

    /**
     * 全局异常处理
     */
    @GetMapping("/businessError")
    public String businessError() {
        throw new BusinessException(0, "异常演示");
    }

    /**
     * 全局异常处理
     */
    @GetMapping("/error")
    @IgnoreResponseAdvice(errorDispose = false)
    public String error() {
        throw new BusinessException(0, "异常演示");
    }

}
