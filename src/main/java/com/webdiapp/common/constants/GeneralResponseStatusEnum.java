package com.webdiapp.common.constants;

public enum GeneralResponseStatusEnum {
    // 执行成功
    CODESUCCESS(0),
    // 执行失败
    CODEFAIL(1);
    private int value;

    private GeneralResponseStatusEnum(int value){
        this.value = value;
    }

    public static GeneralResponseStatusEnum intToEnum(int value) {
        //将数值转换成枚举值
        switch (value) {
            case 0:
                return CODESUCCESS;
            case 1:
                return CODEFAIL;
            default:
                return null;
        }
    }
    public int enumToInt() {
        //将枚举值转换成数值
        return this.value;
    }
    public String enumToString() {
        //将枚举值转换成数值
        return String.valueOf(this.value);
    }
}
