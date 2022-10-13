package com.lingyun.test1.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingyun.test1.cache.HobbyCache;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (User)实体类
 *
 * @author
 * @since 2022-01-26 22:30:09
 */
@Data
@TableName("user_info")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ExcelIgnore
    @TableField(exist = false)
    private Integer id;
    /**
     * 姓名
     */
    @ExcelProperty("姓名")
    private String name;
    /**
     * 年龄
     */
    @ExcelProperty("年龄")
    private Integer age;
    /**
     * 居住地
     */
    @ExcelProperty("居住地")
    private String address;
    /**
     * 性别（1为男 2为女）
     */
    @ExcelIgnore
    private Integer gender;
    /**
     * 性别
     */
    @ExcelProperty("性别")
    @TableField(exist = false)
    private String genderStr;
    /**
     * 爱好(关联子表hobby_info，多个爱好用，隔开)
     */
    @ExcelIgnore
    private String hobby;
    /**
     * 爱好(解析后，多个爱好用，隔开，用于excel展示)
     */
    @TableField(exist = false)
    @ExcelProperty("爱好")
    private String hobbyListName;
    /**
     * 爱好名（解析后）
     */
    @TableField(exist = false)
    @ExcelIgnore
    private List<String> hobbyNames;
    /**
     * 数学分数
     */
    @ExcelProperty("数学")
    private Integer mathsScore;
    /**
     * 英语分数
     */
    @ExcelProperty("英语")
    private Integer englishScore;
    /**
     * 物理分数
     */
    @ExcelProperty("物理")
    private Integer physicsScore;
    /**
     * 身份证号
     */
    @ExcelProperty("身份证")
    private String cardNo;

    @ExcelIgnore
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    @ExcelIgnore
    private Pet pet;

    public User(Pet pet) {
        this.pet = pet;
    }

    //性别数据转换
    public void exGenderStr() {
        if (gender == null) return;
        if (gender == 1) {
            genderStr = "男";
        } else if (gender == 2) {
            genderStr = "女";
        }
    }

    //爱好数据转换
    public void exHobbyListName() {
        if (StringUtils.isNotBlank(hobby)) {
            String[] split = hobby.split(",");
            String hobbyListNameTemp = "";
            List<String> hobbyNamesTemp = new ArrayList<>();
            for (String str : split) {
                String s = HobbyCache.hobbyMap.get(str);
                hobbyListNameTemp += s + ",";
                hobbyNamesTemp.add(s);
            }
            if (StringUtils.isNotBlank(hobbyListNameTemp) &&
                    hobbyListNameTemp.charAt(hobbyListNameTemp.length() - 1) == ',') {
                hobbyListNameTemp = hobbyListNameTemp.substring(0, hobbyListNameTemp.length() - 1);
            }
            hobbyListName = hobbyListNameTemp;
            hobbyNames = hobbyNamesTemp;
        }
    }

}

