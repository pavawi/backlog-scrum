package com.zhonyang.scrum.backlog.common.exception.category;

import com.zhonyang.scrum.backlog.common.exception.error.CommonErrorCode;
import com.zhonyang.scrum.backlog.common.exception.error.details.BusinessErrorCode;

/**
 * @description: {@link RuntimeException} 通用业务异常
 * @author: alan
 * @date: 2021/6/3 22:05
 */
public class BusinessException extends RuntimeException {

    private Integer code;
    private boolean isShowMsg = true;

    public Integer getCode() {
        return code;
    }

    public boolean isShowMsg() {
        return isShowMsg;
    }

    /**
     * 使用枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(BusinessErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用CommonErrorCode枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(CommonErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用自定义消息
     *
     * @param code 值
     * @param msg  详情
     */
    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 使用自定义消息
     *
     * @param msg 详情
     */
    public BusinessException(String msg) {
        super(msg);
        this.code = CommonErrorCode.BUSINESS_ERROR.getCode();
    }

}
