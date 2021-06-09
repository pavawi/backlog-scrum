package com.zhonyang.scrum.backlog.modules.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonyang.scrum.backlog.common.api.CommonPage;
import com.zhonyang.scrum.backlog.common.api.QueryParam;
import com.zhonyang.scrum.backlog.common.constant.CommonConstant;
import com.zhonyang.scrum.backlog.modules.sys.entity.SysUser;
import com.zhonyang.scrum.backlog.modules.sys.mapper.SysUserMapper;
import com.zhonyang.scrum.backlog.modules.sys.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-06-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Override
	public CommonPage<SysUser> queryPage(QueryParam queryParam) {
		StpUtil.setLoginId(1);
		Integer loginId = StpUtil.getLoginIdAsInt();
		IPage<SysUser> page = this.page(
				new Page<>(queryParam.getCurrent(), queryParam.getSize()),
				new LambdaQueryWrapper<SysUser>()
						.like(StringUtils.isNotBlank(queryParam.getKeyword()), SysUser::getUsername,
								queryParam.getKeyword())
						.eq(!loginId.equals(CommonConstant.SUPER_ADMIN), SysUser::getCreatedBy, loginId)
		);
		return new CommonPage(page);
	}

	@Override
	public boolean resetPassword(SysUser currentUser, String password, String newPassword) {
		currentUser.setPassword(newPassword);
		return this.update(currentUser,
				new LambdaQueryWrapper<SysUser>()
						.eq(SysUser::getId, currentUser.getId())
						.eq(SysUser::getPassword, password));
	}

	@Override
	public Boolean saveUser(SysUser user) {
		//md5加盐
		String salt = RandomUtil.randomString(10);
		user.setPassword(SaSecureUtil.md5BySalt(user.getPassword(), salt));
		user.setSalt(salt);
		user.setStatus("N");
		this.save(user);
		return Boolean.TRUE;
	}

	@Override
	public void updateUser(SysUser user) {
		if (StringUtils.isBlank(user.getPassword())) {
			user.setPassword(null);
		} else {
			user.setPassword(SaSecureUtil.md5BySalt(user.getPassword(), user.getSalt()));
		}
		this.updateById(user);

	}

	@Override
	public void deleteBatch(Long[] userIds) {
		this.removeByIds(Arrays.asList(userIds));
	}
}
