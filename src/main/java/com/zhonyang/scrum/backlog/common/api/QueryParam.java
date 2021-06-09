package com.zhonyang.scrum.backlog.common.api;

import com.zhonyang.scrum.backlog.common.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * QueryParam.java
 *
 * @author alan
 * @version 1.0
 * @date 2021/6/9 20:18
 */
@Getter
@Setter
public class QueryParam implements Serializable {
	private static final long serialVersionUID = -3263921252635611410L;

	@ApiModelProperty(value = "页码,默认为1")
	private Integer current = CommonConstant.DEFAULT_PAGE_INDEX;
	@ApiModelProperty(value = "页大小,默认为10")
	private Integer size = CommonConstant.DEFAULT_PAGE_SIZE;
	@ApiModelProperty(value = "搜索字符串")
	private String keyword;

	public void setCurrent(Integer current) {
		if (current == null || current <= 0) {
			this.current = CommonConstant.DEFAULT_PAGE_INDEX;
		} else {
			this.current = current;
		}
	}

	public void setSize(Integer size) {
		if (size == null || size <= 0) {
			this.size = CommonConstant.DEFAULT_PAGE_SIZE;
		} else {
			this.size = size;
		}
	}
}
