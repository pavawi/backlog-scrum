package com.zhonyang.scrum.backlog.common.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * @description: 分页数据封装类
 * @author: alan
 * @date: 2021/6/4 20:50
 */
@Data
public class CommonPage<T> {
	private Long current;
	private Long size;
	private double pages;
	private Long total;
	private List<T> records;

	public static <T> CommonPage<T> restPage(Page<T> page) {
		CommonPage<T> result = new CommonPage<T>();
		result.setCurrent(page.getCurrent());
		result.setSize(page.getSize());
		result.setPages(page.getPages());
		result.setTotal(page.getTotal());
		result.setRecords(page.getRecords());
		return result;
	}


}