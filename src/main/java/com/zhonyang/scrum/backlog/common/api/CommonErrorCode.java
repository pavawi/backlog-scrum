package com.zhonyang.scrum.backlog.common.api;

import org.springframework.http.HttpStatus;

/**
 * @description: 异常枚举
 * @author: alan
 * @date: 2021/6/3 21:31
 */
public enum CommonErrorCode implements IErrorCode {
//    ===================成功==========================

    SUCCESS(200, "操作成功"),

//    ===================客户端错误==========================

    /**
     * 401 UNAUTHORIZED 用户未认证或者认证已过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    /**
     * 403 FORBIDDEN 用户没有相关权限
     */
    FORBIDDEN(403, "没有相关权限"),

    /**
     * 404 Web 服务器找不到您所请求的文件或脚本。请检查URL 以确保路径正确。
     */
    NOT_FOUND(404,
            String.format("哎呀，无法找到这个资源啦(%s)", HttpStatus.NOT_FOUND.getReasonPhrase())),

    /**
     * 405 对于请求所标识的资源，不允许使用请求行中所指定的方法。请确保为所请求的资源设置了正确的 MIME 类型。
     */
    METHOD_NOT_ALLOWED(405,
            String.format("请换个姿势操作试试(%s)", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())),

    /**
     * 415 Unsupported Media Type
     */
    UNSUPPORTED_MEDIA_TYPE(415,
            String.format("呀，不支持该媒体类型(%s)", HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase())),


    /**
     * 系统限流
     */
    TRAFFIC_LIMITING(429, "哎呀，网络拥挤请稍后再试试"),


    /**
     * 参数错误
     */
    PARAM_ERROR(100, "参数错误"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR(400, "业务异常"),

    /**
     * 资源已删除
     */
    GONE_ERROR(410, "资源已删除"),


//    ===================服务端错误==========================


    /**
     * 系统异常 500 服务器的内部错误
     */
    EXCEPTION(500, "服务器开小差，请稍后再试"),

    ;


    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    CommonErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
