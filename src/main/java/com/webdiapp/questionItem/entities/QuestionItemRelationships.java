package com.webdiapp.questionItem.entities;

import com.webdiapp.common.entities.BaseEntity;

import java.util.Date;

public class QuestionItemRelationships extends BaseEntity {
    // 问卷与问题关系的主键
    private Integer relationId;
    // 问卷的主键
    private Integer questionaireId;
    // 问题的主键
    private Integer questionId;
    // 问题类型的主键
    private Integer questionType;
    // 问题的内容
    private String questionContent;
    // 问卷的标题
    private String questionaireTitle;

    private Integer statusId;
    // 问卷的起始有效期
    private Date activeDateStart;
    private Date activeDateEnd;

    private Integer questionItemEnabled;

    private Date questionaireCreationTimestamp;

    private Integer questionaireCreationUser;

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getQuestionaireId() {
        return questionaireId;
    }

    public void setQuestionaireId(Integer questionaireId) {
        this.questionaireId = questionaireId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionaireTitle() {
        return questionaireTitle;
    }

    public void setQuestionaireTitle(String questionaireTitle) {
        this.questionaireTitle = questionaireTitle;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getActiveDateStart() {
        return activeDateStart;
    }

    public void setActiveDateStart(Date activeDateStart) {
        this.activeDateStart = activeDateStart;
    }

    public Date getActiveDateEnd() {
        return activeDateEnd;
    }

    public void setActiveDateEnd(Date activeDateEnd) {
        this.activeDateEnd = activeDateEnd;
    }

    public Integer getQuestionItemEnabled() {
        return questionItemEnabled;
    }

    public void setQuestionItemEnabled(Integer questionItemEnabled) {
        this.questionItemEnabled = questionItemEnabled;
    }

    public Date getQuestionaireCreationTimestamp() {
        return questionaireCreationTimestamp;
    }

    public void setQuestionaireCreationTimestamp(Date questionaireCreationTimestamp) {
        this.questionaireCreationTimestamp = questionaireCreationTimestamp;
    }

    public Integer getQuestionaireCreationUser() {
        return questionaireCreationUser;
    }

    public void setQuestionaireCreationUser(Integer questionaireCreationUser) {
        this.questionaireCreationUser = questionaireCreationUser;
    }
}
