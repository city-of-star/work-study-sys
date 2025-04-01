package com.workstudysys.common.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实现功能【返回体封装】
 *
 * @author li.hongyu
 * @date 2025-03-30 21:53:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // 在序列化时忽略值为null的字段
public class R<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 包含数据的返回方法
     * @param data
     * @return
     */
    public static <T> R<T> success(T data) {
        return new R<>(200, "success", data);
    }

    /**
     * 不包含数据的返回方法
     * @return
     */
    public static <T> R<T> success() {
        return new R<>(200, "success", null);
    }

    /**
     * 错误的请求
     * @param msg
     * @return
     */
    public static <T> R<T> badRequest(String msg) {
        return new R<>(400, msg, null);
    }

    /**
     * 未授权的访问
     * @param msg
     * @return
     */
    public static <T> R<T> unauthorized(String msg) {
        return new R<>(401, msg, null);
    }

    /**
     * 系统内部错误
     * @param msg
     * @return
     */
    public static <T> R<T> serverError(String msg) {
        return new R<>(500, msg, null);
    }
}