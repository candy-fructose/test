package com.lingyun.test1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/25 13:48
 * @Version
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class Pet {
    private int age;
    private String name;

    public Pet(int age) {
        this.age = age;
    }
}
