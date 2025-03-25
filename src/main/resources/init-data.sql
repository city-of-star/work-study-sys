/* 用户表 */
create table `work-study-sys`.user
(
    user_id   int auto_increment comment '用户id'
        primary key,
    username  varchar(50)   not null comment '账号',
    password  varchar(50)   not null comment '密码',
    role      varchar(10)   not null comment '角色',
    real_name varchar(50)   null comment '真实姓名',
    sex       varchar(10)   null comment '性别',
    academy   varchar(50)   null comment '学院',
    major     varchar(50)   null comment '专业',
    head_img  varchar(1000) not null comment '头像',
    grade     varchar(10)   null comment '年级',
    phone     varchar(15)   null comment '手机号码',
    email     varchar(30)   null comment '电子邮箱',
    constraint user_pk_2
        unique (username)
);

/* 工作表 */
create table `work-study-sys`.job
(
    job_id             int auto_increment comment 'id'
        primary key,
    name               varchar(50)  not null comment '工作名称',
    content            varchar(200) null comment '工作内容',
    pay                double       null comment '工资',
    hire_require       varchar(200) null comment '招聘要求',
    work_time          varchar(200) null comment '工作时间',
    work_position      varchar(50)  null comment '工作地点',
    employer           varchar(50)  null comment '用工单位',
    phone              varchar(20)  null comment '联系电话',
    hire_num           int          null comment '招聘人数',
    enroll_num         int          null comment '报名人数',
    interview_time     varchar(50)  null comment '面试时间',
    interview_position varchar(50)  null comment '面试地点',
    status             int          null comment '状态（0：已失效；1：待完善；2：待审核；3：报名中；4：已结束）'
)
    comment '工作表';


