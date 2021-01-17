package com.webdiapp.questionItem.mapper;

import java.util.List;

import com.webdiapp.questionItem.entities.QuestionItemOptionRelationships;

public interface QuestionItemOptionMapper {

    public List<QuestionItemOptionRelationships> getList(int questionaireQuestionId);
    
//    public Question getById(int id);
    
    public int getCount();
    
    public int insert(QuestionItemOptionRelationships entity);
    
    public int delete(int[] ids);
    
    // 根据问卷id，确定了题目。根据题目id, 确定了哪些题目对应的候选项需要删除
    public int removeQuestionItemsByQuestionaireIdWithout(int[] questionIds, int questionaireId);
    // 根据问卷题目的id删除候选项
    public int removeQuestionItemOptionsByQuestionItemIds(int[] questionsId, int questionaireId);
    
}
