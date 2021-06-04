package com.zhonyang.scrum.backlog.common.api;

/**
 * The interface Error code.
 *
 * @description: 封装API的错误码
 * @author: alan
 * @date: 2021 /6/4 20:41
 */
public interface IErrorCode {

    /**
     * Gets code.
     *
     * @return the code
     */
    Integer getCode();

    /**
     * Gets message.
     *
     * @return the message
     */
    String getMessage();
}
