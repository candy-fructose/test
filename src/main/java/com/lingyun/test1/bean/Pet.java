package com.lingyun.test1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/25 13:48
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private int age;
    private String name;
}
