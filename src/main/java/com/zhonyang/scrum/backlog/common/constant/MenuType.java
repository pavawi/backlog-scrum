package com.zhonyang.scrum.backlog.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 菜单类型
 *
 * @author alan
 * @version 1.0
 * @date 2021/6/6 22:16
 */
public enum MenuType {
    /**
     * 目录
     */
    CATALOG("CATALOG", "目录"),
    /**
     * 菜单
     */
    MENU("MENU", "菜单"),
    /**
     * 按钮
     */
    BUTTON("BUTTON", "按钮");

    @EnumValue
    private String code;
    private String describe;

    MenuType(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
