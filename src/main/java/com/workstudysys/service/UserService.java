package com.workstudysys.service;

import com.workstudysys.dto.user.UserLoginRequestDto;
import com.workstudysys.dto.user.UserLoginResponseDto;
import com.workstudysys.entity.User;

/**
 * 实现功能【用户认证服务接口】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:45:40
 */
public interface UserService {

    UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto);

    User getUserInfo();
}