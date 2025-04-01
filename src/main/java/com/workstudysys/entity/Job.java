package com.workstudysys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 实现功能【工作表实体层】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:42:07
 */
@Data
@TableName("job")
public class Job {
    /**
     * 工作id
     */
    @TableId(type = IdType.AUTO)
    private Integer jobId;

    /**
     * 工作名称
     */
    private String name;

    /**
     * 工作内容
     */
    private String content;

    /**
     * 工资
     */
    private Double pay;

    /**
     * 招聘要求
     */
    private String hireRequire;

    /**
     * 工作时间
     */
    private String workTime;

    /**
     * 工作地点
     */
    private String workPosition;

    /**
     * 用工单位
     */
    private String employer;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 招聘人数
     */
    private Integer hireNum;

    /**
     * 报名人数
     */
    private Integer enrollNum;

    /**
     * 面试时间
     */
    private String interviewTime;

    /**
     * 面试地点
     */
    private String interviewPosition;

    /**
     * 状态（0：已失效；1：待完善；2：待审核；3：报名中；4：已结束）
     */
    private Integer status;
}