package com.workstudysys;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 实现功能【】
 *
 * @author li.hongyu
 * @date 2025-03-30 23:51:47
 */
public class JwtUtils {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void generateKey() {
        System.out.println(passwordEncoder.encode("123456"));
    }
}