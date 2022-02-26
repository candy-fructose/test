package com.lingyun.test1;

import com.lingyun.test1.bean.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void contextLoads() {
        List<User> users = jdbcTemplate.queryForList("select * from  user", User.class);
        System.out.println(users.size());
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始啦。。");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束啦。。");
    }

    @Test
    void testRedis() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello", "world");
        String hello = valueOperations.get("hello");
        assertEquals("world", hello, "业务逻辑判断失败");
        //如果前面断言失败，则之后的代码都不会执行
//        assertEquals("hello", hello, "业务逻辑判断失败");
        //组合断言
//        assertAll("test", () -> assertTrue(true && true),
//                () -> assertEquals(1, 2));

        System.out.println("=====");
        //断言异常，有异常才是正常的
        assertThrows(ArithmeticException.class,()->{
            int i = 10/2;
        });
    }

}
