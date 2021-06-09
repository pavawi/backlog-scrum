package com.zhonyang.scrum.backlog.modules.sys.controller;


import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zhonyang.scrum.backlog.common.annotation.SysLog;
import com.zhonyang.scrum.backlog.common.api.CommonPage;
import com.zhonyang.scrum.backlog.common.api.QueryParam;
import com.zhonyang.scrum.backlog.common.constant.CommonConstant;
import com.zhonyang.scrum.backlog.common.exception.BusinessException;
import com.zhonyang.scrum.backlog.common.group.Add;
import com.zhonyang.scrum.backlog.common.group.Update;
import com.zhonyang.scrum.backlog.modules.sys.entity.SysUser;
import com.zhonyang.scrum.backlog.modules.sys.model.ResetPasswordParam;
import com.zhonyang.scrum.backlog.modules.sys.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-06-06
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

	@Resource
	ISysUserService sysUserService;


	/**
	 * 所有用户列表
	 */
	@GetMapping("/")
	@ApiOperation("所有用户列表")
	public CommonPage<SysUser> list(QueryParam queryParam) {
		return sysUserService.queryPage(queryParam);
	}


	/**
	 * 根据ID获取用户信息,传空默认获取本人信息
	 */
	@GetMapping("/{id}")
	@ApiOperation("根据ID获取用户信息,传空默认获取本人信息")
	public SysUser info(@PathVariable(required = false, value = "id") Integer id) {
		if (ObjectUtil.isNull(id)) {
			id = StpUtil.getLoginIdAsInt();
		}
		return sysUserService.getById(id);
	}


	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@PutMapping("/password")
	@ApiOperation("修改密码")
	public void resetPassword(@RequestBody @Validated ResetPasswordParam resetPasswordParam) {
		StpUtil.setLoginId(1);
		SysUser currentUser = sysUserService.getById(StpUtil.getLoginIdAsInt());
		//sha256加密
		String password = SaSecureUtil.md5BySalt(resetPasswordParam.getPassword(), currentUser.getSalt());
		//sha256加密
		String newPassword = SaSecureUtil.md5BySalt(resetPasswordParam.getNewPassword(), currentUser.getSalt());

		//更新密码
		boolean flag = sysUserService.resetPassword(currentUser, password, newPassword);
		if (!flag) {
			throw new BusinessException("原密码不正确");
		}

	}

	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@PostMapping("/")
	@ApiOperation("保存用户")
	public void save(@RequestBody @Validated({Add.class}) SysUser user) {
		sysUserService.saveUser(user);
	}

	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@PutMapping("/")
	@ApiOperation("修改用户")
	public void update(@RequestBody @Validated({Update.class}) SysUser user) {
		sysUserService.updateUser(user);
	}

	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@DeleteMapping("/")
	@ApiOperation("删除用户")
	public void delete(@RequestBody Long[] userIds) {
		if (ArrayUtil.contains(userIds, CommonConstant.SUPER_ADMIN)) {
			throw new BusinessException("系统管理员不能删除");
		}

		if (ArrayUtil.contains(userIds, StpUtil.getLoginIdAsLong())) {
			throw new BusinessException("当前用户不能删除");
		}

		sysUserService.deleteBatch(userIds);
	}

}
