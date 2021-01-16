package com.webdiapp.common.constants;

public enum GeneralRemoveStatusEnum {
    // 删除成功
    REMOVESUCCESS(0),
    // 不存在
    NOTEXISTS(1),
    // 删除失败
    REMOVEFAIL(2);
    private int value;

    private GeneralRemoveStatusEnum(int value){
        this.value = value;
    }

    public static GeneralRemoveStatusEnum intToEnum(int value) {
        //将数值转换成枚举值
        switch (value) {
            case 0:
                return REMOVESUCCESS;
            case 1:
                return NOTEXISTS;
            case 2:
                return REMOVEFAIL;
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

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
