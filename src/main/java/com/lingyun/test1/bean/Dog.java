package com.lingyun.test1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/8 21:04
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "mydog")

public class Dog {
    private String name;
    private Integer age;
}
