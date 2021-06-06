package com.zhonyang.scrum.backlog.modules.sys.mapper;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.zhonyang.scrum.backlog.modules.sys.entity.SysUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class SysUserMapperTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Order(1)
    @Test
    public void testInstall() {
        StpUtil.setLoginId(10);
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        assertEquals(0, sysUsers.size());
        SysUser sysUser = new SysUser();
        sysUser.setUsername("alan");
        String salt = RandomUtil.randomString(10);
        sysUser.setSalt(salt);
        sysUser.setPassword(SaSecureUtil.md5BySalt("123456", salt));
        sysUser.setStatus("N");
        sysUserMapper.insert(sysUser);
        assertEquals(0, sysUser.getDeleted());
        assertEquals(0, sysUser.getRevision());
        assertEquals(10, sysUser.getCreatedBy());
        assertNotNull(sysUser.getCreatedTime());
    }

    @Order(2)
    @Test
    public void testUpdate() {
        StpUtil.setLoginId(10);
        SysUser sysUser = sysUserMapper.selectById(1);
        sysUser.setStatus("Y");
        sysUserMapper.updateById(sysUser);
        assertEquals(0, sysUser.getDeleted());
        assertEquals(1, sysUser.getRevision());
        assertEquals(10, sysUser.getCreatedBy());
        assertNotNull(sysUser.getCreatedTime());
        assertEquals(10, sysUser.getUpdatedBy());
        assertNotNull(sysUser.getUpdatedBy());
    }

    @Order(3)
    @Test
    public void testDeleted() {
        sysUserMapper.deleteById(1);
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        assertEquals(0, sysUsers.size());
    }


}