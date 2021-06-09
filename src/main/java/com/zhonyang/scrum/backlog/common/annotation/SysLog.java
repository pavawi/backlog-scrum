package com.zhonyang.scrum.backlog.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author alan
 * @version 1.0
 * @date 2021/6/9 20:45
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}

