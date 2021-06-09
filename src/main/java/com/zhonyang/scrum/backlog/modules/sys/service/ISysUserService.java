package com.zhonyang.scrum.backlog.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonyang.scrum.backlog.common.api.CommonPage;
import com.zhonyang.scrum.backlog.common.api.QueryParam;
import com.zhonyang.scrum.backlog.modules.sys.entity.SysUser;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author jobob
 * @since 2021 -06-06
 */
public interface ISysUserService extends IService<SysUser> {

	/**
	 * Query page common page.
	 *
	 * @param queryParam the query param
	 * @return the common page
	 */
	CommonPage<SysUser> queryPage(QueryParam queryParam);

	/**
	 * Reset password boolean.
	 *
	 * @param currentUser the current user
	 * @param password    the password
	 * @param newPassword the new password
	 * @return the boolean
	 */
	boolean resetPassword(SysUser currentUser, String password, String newPassword);

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return
	 */
	Boolean saveUser(SysUser user);

	/**
	 * Update user.
	 *
	 * @param user the user
	 */
	void updateUser(SysUser user);

	/**
	 * Delete batch.
	 *
	 * @param userIds the user ids
	 */
	void deleteBatch(Long[] userIds);
}
