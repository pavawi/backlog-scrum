package com.zhonyang.scrum.backlog.common.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 *
 * @author alan
 * @date 2017-03-15 23:15
 */
@GroupSequence({Add.class, Update.class})
public interface Group {

}
