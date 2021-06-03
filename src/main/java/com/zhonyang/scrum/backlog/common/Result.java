package com.zhonyang.scrum.backlog.common;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zhonyang.scrum.backlog.common.exception.error.CommonErrorCode;
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
     * 服务器当前时间戳
     */
    private Long ts = System.currentTimeMillis();

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
        result.code = 200;
        result.msg = "ok";
        return result;
    }

    public static Result ofSuccess(Object data) {
        Result result = new Result();
        result.code = 200;
        result.msg = "ok";
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
    public String buildResultJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code", this.code);
        jsonObject.set("ts", this.ts);
        jsonObject.set("msg", this.msg);
        jsonObject.set("data", this.data);
        return JSONUtil.toJsonStr(jsonObject);
    }
}
