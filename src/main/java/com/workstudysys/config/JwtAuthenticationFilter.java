package com.workstudysys.config;

import com.workstudysys.common.exception.AuthException;
import com.workstudysys.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 实现功能【jwt 认证过滤类】
 *
 * @author li.hongyu
 * @date 2025-03-30 22:34:12
 */
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 从请求头获取Token
        String authHeader = request.getHeader("token");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        try {
            // 验证并解析Token
            String username = JwtUtils.extractUsername(token);

            // 创建用户
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 将用户信息注入到上下文
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        } catch (ExpiredJwtException ex) {
            log.warn("Token已过期: {}", ex.getMessage());
            throw new AuthException("token已过期");
        } catch (SignatureException ex) {
            log.warn("无效的Token签名: {}", ex.getMessage());
            throw new AuthException("无效的Token签名");
        } catch (Exception ex) {
            log.error("认证错误: {}", ex.getMessage());
            throw new AuthException("认证错误");
        }

        filterChain.doFilter(request, response);
    }

}