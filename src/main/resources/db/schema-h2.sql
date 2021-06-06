DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    parent_id    BIGINT COMMENT '父菜单ID，一级菜单为0',
    name         VARCHAR(32) COMMENT '菜单名称',
    url          VARCHAR(1024) COMMENT '菜单URL',
    perms        VARCHAR(1024) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
    type         VARCHAR(32) COMMENT '类型目录;菜单;按钮',
    icon         VARCHAR(128) COMMENT '菜单图标',
    order_number INT COMMENT '排序'
);
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    name         VARCHAR(32) COMMENT '角色名称',
    remark       VARCHAR(32) COMMENT '备注'
);
DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    menu_id      BIGINT COMMENT '菜单ID',
    role_id      BIGINT COMMENT '角色ID'
);
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    username     VARCHAR(32) COMMENT '用户名',
    salt         VARCHAR(32) COMMENT '随机盐',
    password     VARCHAR(128) COMMENT '密码',
    status       VARCHAR(32) COMMENT '用户状态'
);
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    id           INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    user_id      BIGINT COMMENT '用户ID',
    role_id      BIGINT COMMENT '角色ID'
);
DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    username     VARCHAR(32) COMMENT '用户名',
    operation    VARCHAR(32) COMMENT '用户操作',
    method       VARCHAR(128) COMMENT '请求方法',
    params       VARCHAR(1024) COMMENT '请求参数',
    time         BIGINT COMMENT '执行时长(毫秒)',
    ip           VARCHAR(64) COMMENT 'IP地址'
);
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
    id             BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision       INT        DEFAULT 0 COMMENT '乐观锁',
    created_by     BIGINT COMMENT '创建人',
    created_time   DATETIME COMMENT '创建时间',
    updated_by     BIGINT COMMENT '更新人',
    updated_time   DATETIME COMMENT '更新时间',
    deleted        VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    open_id        VARCHAR(64) COMMENT '微信Open ID',
    nickname       VARCHAR(64) COMMENT '微信昵称',
    head_image_url VARCHAR(128) COMMENT '微信头像',
    phone          VARCHAR(32) COMMENT '手机号码'
);
DROP TABLE IF EXISTS t_project;
CREATE TABLE t_project
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    name         VARCHAR(128) COMMENT '项目名称',
    code         VARCHAR(32) COMMENT '项目代号',
    start_time   DATETIME COMMENT '开始时间',
    end_time     DATETIME COMMENT '结束时间',
    status       VARCHAR(32) COMMENT '项目状态',
    invite_code  VARCHAR(32) COMMENT '邀请码'
);
DROP TABLE IF EXISTS t_project_backlog;
CREATE TABLE t_project_backlog
(
    id                  BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision            INT        DEFAULT 0 COMMENT '乐观锁',
    created_by          BIGINT COMMENT '创建人',
    created_time        DATETIME COMMENT '创建时间',
    updated_by          BIGINT COMMENT '更新人',
    updated_time        DATETIME COMMENT '更新时间',
    deleted             VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    no                  VARCHAR(128) COMMENT '编号',
    module_id           BIGINT COMMENT '功能模块',
    type                VARCHAR(32) COMMENT '需求类型',
    name                VARCHAR(128) COMMENT '需求名称',
    user_story          VARCHAR(512) COMMENT '用户故事',
    priority            INT COMMENT '优先级',
    proposer            VARCHAR(128) COMMENT '提出人',
    proposer_id         BIGINT COMMENT '提出人ID(用户ID)',
    propose_time        DATETIME COMMENT '提出时间',
    source              VARCHAR(32) COMMENT '需求来源',
    status              VARCHAR(32) COMMENT '需求状态',
    development_version VARCHAR(32) COMMENT '开发版本',
    remark              VARCHAR(512) COMMENT '备注'
);
DROP TABLE IF EXISTS t_project_module;
CREATE TABLE t_project_module
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    name         VARCHAR(32) COMMENT '名称',
    parent_id    BIGINT COMMENT '父菜单ID，一级菜单为0',
    order_number VARCHAR(32) COMMENT '排序',
    project_id   BIGINT COMMENT '项目ID'
);
DROP TABLE IF EXISTS t_project_user;
CREATE TABLE t_project_user
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    revision     INT        DEFAULT 0 COMMENT '乐观锁',
    created_by   BIGINT COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   BIGINT COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    deleted      VARCHAR(1) DEFAULT 0 COMMENT '逻辑删除',
    user_id      BIGINT COMMENT '用户ID',
    project_id   BIGINT COMMENT '项目ID',
    role_type    VARCHAR(32) COMMENT '角色类型:创建者;管理者;用户;'
);
