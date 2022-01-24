package com.lingyun.test1.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author LingYun
 * @Date 2021/4/28 22:03
 * @Version
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(ArithmeticException e) {
        log.error("异常是:{}" ,e);
        return "login";
    }

}
