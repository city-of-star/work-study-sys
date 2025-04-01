package com.workstudysys.config;

import com.workstudysys.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 从请求头获取Token
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        try {
            // 验证并解析Token
            String username = JwtUtils.extractUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 创建简单认证对象（无权限信息）
                //UsernamePasswordAuthenticationToken authentication =
                //        new UsernamePasswordAuthenticationToken(username, null, null);
                //SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ExpiredJwtException ex) {
            log.warn("Token已过期: " + ex.getMessage());
        } catch (SignatureException ex) {
            log.warn("无效的Token签名: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("认证错误: " + ex.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}