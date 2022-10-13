package com.lingyun.test1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Car
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/25 14:09
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ConfigurationProperties(prefix = "mycar")//从配置文件中获取参数
@Component// 注入容器  如果Myconfig中配置了@EnableConfigurationProperties(Car.class)就可以省略
public class Car {
    private String brand;
    private Integer price;
    private User user;

    public Car(User user) {
        this.user = user;
    }
}
