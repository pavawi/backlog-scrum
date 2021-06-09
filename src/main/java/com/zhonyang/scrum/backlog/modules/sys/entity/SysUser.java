package com.zhonyang.scrum.backlog.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zhonyang.scrum.backlog.common.db.BaseEntity;
import com.zhonyang.scrum.backlog.common.group.Add;
import com.zhonyang.scrum.backlog.common.group.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author jobob
 * @since 2021-06-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空", groups = {Add.class, Update.class})
	private String username;

    /**
     * 随机盐
     */
    private String salt;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空", groups = Add.class)
	private String password;

    /**
     * 用户状态
     */
    private String status;


}
