package com.zhonyang.scrum.backlog.modules.sys.controller;


import com.zhonyang.scrum.backlog.modules.sys.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统角色  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-06-07
 */
@RestController
@RequestMapping("/sys/sys-role")
public class SysRoleController {
	@Autowired
	private ISysRoleService sysRoleService;

}
