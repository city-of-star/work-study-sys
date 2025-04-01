package com.workstudysys.service;

import com.workstudysys.common.request.R;
import com.workstudysys.dto.user.UserLoginRequestDto;
import com.workstudysys.dto.user.UserLoginResponseDto;

/**
 * 实现功能【用户认证服务接口】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:45:40
 */
public interface UserService {

    UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto);

}