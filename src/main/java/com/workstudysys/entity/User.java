package com.workstudysys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 实现功能【用户表实体】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:29:15
 */
@Data
@TableName("sys_user")
public class User {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学院
     */
    private String academy;

    /**
     * 专业
     */
    private String major;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 年级
     */
    private String grade;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;
}