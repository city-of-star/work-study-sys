package com.workstudysys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workstudysys.entity.Job;
import org.apache.ibatis.annotations.Mapper;

/**
 * 实现功能【工作表的 mapper】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:44:34
 */
@Mapper
public interface JobMapper extends BaseMapper<Job> {

}