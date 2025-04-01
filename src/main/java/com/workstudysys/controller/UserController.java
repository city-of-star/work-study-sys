package com.workstudysys.controller;

import com.workstudysys.common.request.R;
import com.workstudysys.dto.user.UserLoginRequestDto;
import com.workstudysys.dto.user.UserLoginResponseDto;
import com.workstudysys.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现功能【用户服务 controller】
 *
 * @author li.hongyu
 * @date 2025-03-30 22:57:18
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public R<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return R.success(userService.login(userLoginRequestDto));
    }
}