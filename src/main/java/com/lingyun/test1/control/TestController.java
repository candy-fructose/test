package com.lingyun.test1.control;

import com.lingyun.test1.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/28 22:10
 * @Version
 */
@RequestMapping("/exception")
@RestController
@Slf4j
public class TestController {
    @GetMapping("/testExceptionHandler")
    public void testExceptionHandler(){
        int i = 10/0;
    }
    @GetMapping("/testMyExceptionHandler")
    public void testMyExceptionHandler(){
        throw new MyException();
    }

}
