package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionaireQuestionR;

public interface QuestionaireQuestionService {

    public List<QuestionaireQuestionR> getList(int questionaireId);

    public QuestionaireQuestionR getById(int id);

    public int getCount();

    public int insert(QuestionaireQuestionR entity);

    public int delete(int[] ids);

}
