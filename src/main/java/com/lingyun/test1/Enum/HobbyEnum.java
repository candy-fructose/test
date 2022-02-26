package com.lingyun.test1.Enum;

/**
 * @ClassName HobbyEnum
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/28 21:03
 * @Version
 */
public enum HobbyEnum {
    MONDAY("星期一", 1),
    TUESDAY("星期二", 2),
    WEDNESDAY("星期三", 3),
    THURSDAY("星期四", 4),
    FRIDAY("星期五", 5),
    SATURDAY("星期六", 6),
    SUNDAY("星期日", 7);//记住要用分号结束

    private String value;//文字描述
    private Integer code; //对应的代码

    /**
     * 私有构造,防止被外部调用
     *
     * @param value
     */
    private HobbyEnum(String value, Integer code) {
        this.value = value;
        this.code = code;
    }

    /**
     * 定义方法,返回描述,跟常规类的定义没区别
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * 定义方法,返回代码,跟常规类的定义没区别
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 根据code获取去value
     * @param code
     * @return
     */
    public static String getValueByCode(String code){
        for(HobbyEnum hobbyEnum:HobbyEnum.values()){
            if(code.equals(hobbyEnum.getCode())){
                return hobbyEnum.getValue();
            }
        }
        return  null;
    }
}

