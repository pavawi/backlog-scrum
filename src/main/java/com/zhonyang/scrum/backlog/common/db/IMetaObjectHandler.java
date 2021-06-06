package com.zhonyang.scrum.backlog.common.db;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mybatis-Plus 填充器
 *
 * @author alan
 * @version 1.0
 * @date 2021/6/6 22:27
 */
@Component
public class IMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "deleted", () -> 0, Integer.class);
        this.strictInsertFill(metaObject, "revision", () -> 0, Integer.class);
        this.strictInsertFill(metaObject, "createdTime", LocalDateTime::now, LocalDateTime.class);
        if (StpUtil.isLogin()) {
            this.strictInsertFill(metaObject, "createdBy", StpUtil::getLoginIdAsLong, Long.class);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime::now, LocalDateTime.class);
        if (StpUtil.isLogin()) {
            this.strictUpdateFill(metaObject, "updatedBy", StpUtil::getLoginIdAsLong, Long.class);
        }
    }

}
