package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.QuestionaireQuestion;
import com.webdiapp.vo.QuestionaireQuestionRVO;

public interface QuestionaireQuestionService {

    public List<QuestionaireQuestionRVO> getList(int questionaireId);

    public QuestionaireQuestion getById(int id);

    public int getCount();

    public int insert(QuestionaireQuestion entity);

    public int delete(int[] ids);

}
