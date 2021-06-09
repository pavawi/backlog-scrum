package com.zhonyang.scrum.backlog.common.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

	public CommonPage() {
	}

	public CommonPage(IPage<T> page) {
		this.setCurrent(page.getCurrent());
		this.setSize(page.getSize());
		this.setPages(page.getPages());
		this.setTotal(page.getTotal());
		this.setRecords(page.getRecords());
	}

}