package com.lingyun.test1.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName Person
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/8 21:23
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Primary
public class Person{
    private String name;
    private Integer age;
}