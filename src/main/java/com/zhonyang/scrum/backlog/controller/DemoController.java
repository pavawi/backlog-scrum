package com.zhonyang.scrum.backlog.controller;

import com.zhonyang.scrum.backlog.common.annotation.IgnoreResponseAdvice;
import com.zhonyang.scrum.backlog.common.exception.category.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    /**
     * 测试 返回为 string类型 值为 不为null
     */
    @GetMapping("test")
    @ApiOperation("test")
    public String test() {
        return "test";
    }

    /**
     * 测试 返回为 String类型 值为 null
     */
    @GetMapping("test-null")
    @ApiOperation("test-null")
    public String testNull() {
        return null;
    }

    /**
     * 测试 返回为 object类型 值为 null
     */
    @GetMapping("object-null")
    @ApiOperation("object-null")

    public Object objectNull() {
        return null;
    }

    /**
     * 测试 返回为 list类型 值为 null
     */
    @GetMapping("test-list-null")
    @ApiOperation("test-list-null")

    public List<String> testListNull() {
        return null;
    }

    /**
     * {@link IgnoreResponseAdvice} 使用
     */
    @IgnoreResponseAdvice
    @GetMapping("ignor")
    @ApiOperation("ignor")
    public String ignor() {
        return "ignor";
    }

    /**
     * 全局异常处理
     */
    @GetMapping("businessError")
    @ApiOperation("businessError")
    public String businessError(String test) {
        throw new BusinessException(0, "异常演示");
    }
}
