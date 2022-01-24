package com.lingyun.test1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName MyException
 * @Description 自定义异常处理器
 * @Author LingYun
 * @Date 2021/4/28 22:34
 * @Version
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY,reason = "网络异常")
public class MyException extends RuntimeException{

    public MyException() {
    }
    public MyException(String message) {
        super(message);
    }
}
