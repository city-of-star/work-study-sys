package com.workstudysys.config;

import com.workstudysys.common.exception.AuthException;
import com.workstudysys.entity.User;
import com.workstudysys.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 实现功能【用户认证业务实现类】
 *
 * @author li.hongyu
 * @date 2025-04-06 13:31:48
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);

        if (user == null) {
            throw new AuthException("用户不存在");
        }

        return new UserDetailsImpl(user);
    }
}