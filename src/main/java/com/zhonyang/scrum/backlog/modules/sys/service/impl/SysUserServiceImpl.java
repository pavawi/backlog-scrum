package com.zhonyang.scrum.backlog.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonyang.scrum.backlog.modules.sys.entity.SysUser;
import com.zhonyang.scrum.backlog.modules.sys.mapper.SysUserMapper;
import com.zhonyang.scrum.backlog.modules.sys.service.ISysUserService;
import org.springframework.stereotype.Service;

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

}
