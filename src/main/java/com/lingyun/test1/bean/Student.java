package com.lingyun.test1.bean;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author LXZ
 * @Date 2022/3/24 16:02
 * @Version
 */
@Data
@AllArgsConstructor
public class Student {
    String name;
    Integer age;
    Integer rank;

    public static void main(String[] args) {
//        Integer long1 = null;
//        Integer long2 = 0;
//        long2 += long1;
//        System.out.println( long2);
        Date startDate = DateUtil.parse("2021-09", "yyyy-MM");
        DateTime dateTime = DateUtil.beginOfMonth(startDate);
        DateTime dateTime2 = DateUtil.endOfMonth(startDate);
        System.out.println(dateTime);
        System.out.println(dateTime2);
        System.out.println(startDate);
    }
}