package com.zhonyang.scrum.backlog.common.exception.error.details;

/**
 * @description: 业务通用异常枚举
 * @author: alan
 * @date: 2021/6/3 21:33
 */
public enum BusinessErrorCode {
    /**
     * 通用业务异常
     */
    GONE_ERROR(410, "资源已删除"),
    ;

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    BusinessErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
