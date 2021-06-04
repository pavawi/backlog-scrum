package com.zhonyang.scrum.backlog.common.api;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 返回统一数据结构
 * @author: alan
 * @date: 2021/6/3 22:16
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {


    /**
     * 成功数据
     */
    private T data;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String msg;

    public static Result ofSuccess() {
        Result result = new Result();
        result.code = CommonErrorCode.SUCCESS.getCode();
        result.msg = CommonErrorCode.SUCCESS.getMessage();
        return result;
    }

    public static Result ofSuccess(Object data) {
        Result result = new Result();
        result.code = CommonErrorCode.SUCCESS.getCode();
        result.msg = CommonErrorCode.SUCCESS.getMessage();
        result.setData(data);
        return result;
    }

    public static Result ofFail(Integer code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static Result ofFail(Integer code, String msg, Object data) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        result.setData(data);
        return result;
    }

    public static Result ofFail(CommonErrorCode resultEnum) {
        Result result = new Result();
        result.code = resultEnum.getCode();
        result.msg = resultEnum.getMessage();
        return result;
    }

    /**
     * 获取 json
     */
    public String buildResultJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code", this.code);
        jsonObject.set("msg", this.msg);
        jsonObject.set("data", this.data);
        return JSONUtil.toJsonStr(jsonObject);
    }
}
