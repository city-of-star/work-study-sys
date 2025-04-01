package com.workstudysys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.workstudysys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 实现功能【用户表的 mapper】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:44:07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select password from user where username = #{username}")
    User selectByUsername(String username);

}