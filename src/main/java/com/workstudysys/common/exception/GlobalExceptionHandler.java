package com.workstudysys.common.exception;

import com.workstudysys.common.request.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 实现功能【全局异常处理类】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:48:04
 */
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public R handleGlobalException(GlobalException e) {
        log.error("---------- 系统内部错误：{{}} ----------", e.getMessage());
        return R.serverError(e.getMessage());
    }

    @ExceptionHandler(AuthException.class)
    public R handleAuthException(GlobalException e) {
        log.error("---------- 未授权的访问：{{}} ----------", e.getMessage());
        return R.unauthorized(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public R handleBadRequestException(GlobalException e) {
        log.error("---------- 错误的请求：{{}} ----------", e.getMessage());
        return R.badRequest(e.getMessage());
    }

}