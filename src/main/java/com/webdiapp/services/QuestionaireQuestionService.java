package com.webdiapp.services;

import java.util.List;

import com.webdiapp.vo.QuestionaireQuestionRVO;

public interface QuestionaireQuestionService {

    public List<QuestionaireQuestionRVO> getList(int questionaireId);

    public QuestionaireQuestionRVO getById(int id);

    public int getCount();

    public int insert(QuestionaireQuestionRVO entity);

    public int delete(int[] ids);

}
