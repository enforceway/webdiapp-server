package com.webdiapp.questionaire.constants;

import com.webdiapp.common.constants.GeneralResponseStatus;

public enum QuestionaireRemoveStatus {
    // 删除成功
    REMOVESUCCESS(0),
    // 不存在
    NOTEXISTS(1),
    // 删除失败
    REMOVEFAIL(2);
    private int value;

    private QuestionaireRemoveStatus(int value){
        this.value = value;
    }

    public static QuestionaireRemoveStatus intToEnum(int value) {
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
}
