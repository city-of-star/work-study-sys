package com.workstudysys.dto.user;

import lombok.Data;

/**
 * 实现功能【用户登录请求 dto】
 *
 * @author li.hongyu
 * @date 2025-03-30 22:21:07
 */
@Data
public class UserLoginRequestDto {
    private String username;
    private String password;
}