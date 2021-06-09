package com.zhonyang.scrum.backlog.modules.sys.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 重置密码
 *
 * @author alan
 * @version 1.0
 * @date 2021/6/9 20:47
 */
@Data
public class ResetPasswordParam {
	/**
	 * 原密码
	 */
	@NotBlank(message = "原密码不为能空")
	private String password;
	/**
	 * 新密码
	 */
	@NotBlank(message = "新密码不为能空")
	private String newPassword;
}
