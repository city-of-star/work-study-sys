package com.workstudysys.service.impl;

import com.workstudysys.common.exception.BadRequestException;
import com.workstudysys.common.request.R;
import com.workstudysys.dto.user.UserLoginRequestDto;
import com.workstudysys.dto.user.UserLoginResponseDto;
import com.workstudysys.entity.User;
import com.workstudysys.mapper.UserMapper;
import com.workstudysys.service.UserService;
import com.workstudysys.utils.JwtUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 实现功能【用户认证服务实现类】
 *
 * @author li.hongyu
 * @date 2025-03-30 22:24:41
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {

        if (userLoginRequestDto.getUsername() == null || userLoginRequestDto.getPassword() == null) {
            throw new BadRequestException("用户名或密码未输入");
        }

        // 查询用户密码
        User user = userMapper.selectByUsername(userLoginRequestDto.getUsername());

        if (user == null || !user.getPassword().equals(userLoginRequestDto.getPassword())) {
            throw new BadRequestException("用户名或密码错误");
        }

        // 生成 token
        String token = JwtUtils.generateToken(userLoginRequestDto.getUsername());

        log.info("---------- 用户登录成功：{用户名：{}，登录时间：{}} ----------", userLoginRequestDto.getUsername(), new Date());

        return new UserLoginResponseDto(token);
    }
}