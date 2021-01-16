package com.webdiapp.questionItem.mapper;

import java.util.List;

import com.webdiapp.questionItem.entities.QuestionItemRelationships;
import com.webdiapp.questionaire.entities.QuestionaireQuestion;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface QuestionRelationMapper {

	public int removeQuestionItemsByQuestionItemIds(@Param("questionsIds") int[] questionsIds, @Param("questionaireId") int questionaireId);
    // 根据问卷主键，列出对应所有问卷中的问题
    public List<QuestionItemRelationships> getQuestionItemList(int questionaireId);
    // 根据
//    public QuestionItemRelationships getById(int id);
    // 根据问卷主键，列出对应问卷中问题数量
    public int getCount();

    public int insert(QuestionaireQuestion entity);

    public int delete(int[] ids);

//    public int update(Question entity);
}
