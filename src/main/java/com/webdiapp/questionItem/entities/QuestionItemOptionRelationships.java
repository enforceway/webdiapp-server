package com.webdiapp.questionItem.entities;

import com.webdiapp.common.entities.BaseEntity;

public class QuestionItemOptionRelationships extends BaseEntity {
    private Integer id;
    private Integer questionItemId;
    private String optionContent;
    private Integer selected; // 1代表选中，0代表未选中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionItemId() {
        return questionItemId;
    }

    public void setQuestionItemId(Integer questionItemId) {
        this.questionItemId = questionItemId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}