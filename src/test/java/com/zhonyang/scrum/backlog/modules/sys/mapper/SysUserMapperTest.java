package com.zhonyang.scrum.backlog.modules.sys.mapper;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhonyang.scrum.backlog.common.api.CommonPage;
import com.zhonyang.scrum.backlog.common.constant.CommonConstant;
import com.zhonyang.scrum.backlog.modules.sys.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Slf4j
@SpringBootTest
public class SysUserMapperTest {

	@Resource
	private SysUserMapper sysUserMapper;

	@Order(1)
	@Test
	public void testInstall() {
		StpUtil.setLoginId(CommonConstant.SUPER_ADMIN);
		SysUser sysUser = new SysUser();
		sysUser.setUsername("alan");
		String salt = RandomUtil.randomString(10);
		sysUser.setSalt(salt);
		sysUser.setPassword(SaSecureUtil.md5BySalt("123456", salt));
		sysUser.setStatus("N");
		sysUserMapper.insert(sysUser);
		assertEquals(0, sysUser.getDeleted());
		assertEquals(0, sysUser.getRevision());
		assertEquals(CommonConstant.SUPER_ADMIN, sysUser.getCreatedBy());
		assertNotNull(sysUser.getCreatedTime());
	}

	@Order(2)
	@Test
	public void testUpdate() {
		StpUtil.setLoginId(CommonConstant.SUPER_ADMIN);
		SysUser sysUser = sysUserMapper.selectById(2);
		sysUser.setStatus("Y");
		sysUserMapper.updateById(sysUser);
		assertEquals(0, sysUser.getDeleted());
		assertEquals(1, sysUser.getRevision());
		assertEquals(CommonConstant.SUPER_ADMIN, sysUser.getCreatedBy());
		assertNotNull(sysUser.getCreatedTime());
		assertEquals(CommonConstant.SUPER_ADMIN, sysUser.getUpdatedBy());
		assertNotNull(sysUser.getUpdatedBy());
	}

	@Order(3)
	@Test
	public void testDeleted() {
		sysUserMapper.deleteById(1);
		List<SysUser> sysUsers = sysUserMapper.selectList(null);
		assertEquals(6, sysUsers.size());
	}


	@Order(4)
	@Test
	public void testPage() {

		Page<SysUser> page = new Page<>(1, 5);

		Page<SysUser> sysUserPage = sysUserMapper.selectPage(page,
				new LambdaQueryWrapper<SysUser>().eq(SysUser::getStatus, "N"));

		CommonPage<SysUser> commonPage = new CommonPage(sysUserPage);
		log.info("总条数 -------------> {}", commonPage.getTotal());
		log.info("当前页数 -------------> {}", commonPage.getCurrent());
		log.info("当前每页显示数 -------------> {}", commonPage.getSize());
		assertEquals(7, commonPage.getTotal());
		assertEquals(2, commonPage.getPages());
		assertThat(commonPage.getRecords()).isNotEmpty();

	}


}