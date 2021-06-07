package com.zhonyang.scrum.backlog.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zhonyang.scrum.backlog.common.db.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统角色
 * </p>
 *
 * @author jobob
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 备注
	 */
	private String remark;


}
