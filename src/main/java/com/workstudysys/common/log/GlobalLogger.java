package com.workstudysys.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现功能【全局日志记录】
 *
 * @author li.hongyu
 * @date 2025-03-30 22:05:25
 */
public class GlobalLogger {

    public static Logger getLogger() {
        Class<?> clazz = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .getCallerClass();
        return LoggerFactory.getLogger(clazz);
    }

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void warn(String message) {
        getLogger().warn(message);
    }

    public static void debug(String message) {
        getLogger().debug(message);
    }

    public static void error(String message) {
        getLogger().error(message);
    }
}