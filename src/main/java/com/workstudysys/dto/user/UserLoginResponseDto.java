package com.workstudysys.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实现功能【用户登录响应 dto】
 *
 * @author li.hongyu
 * @date 2025-03-30 22:22:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDto {
    private String token;
}