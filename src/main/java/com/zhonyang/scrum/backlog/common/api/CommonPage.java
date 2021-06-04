package com.zhonyang.scrum.backlog.common.api;

import lombok.Data;

import java.util.List;

/**
 * @description: 分页数据封装类
 * @author: alan
 * @date: 2021/6/4 20:50
 */
@Data
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;
}