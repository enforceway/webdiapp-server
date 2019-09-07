package com.webdiapp.services;

import java.util.ArrayList;
import java.util.List;

import com.webdiapp.vo.QuestionaireQuestionRVO;

public interface QuestionaireQuestionService {
	
	public int removeQuestionsByIdsWithout(int ids[]);

	public int removeQuestionsByIds(int ids[]);

    public List<QuestionaireQuestionRVO> getList(int questionaireId);

    public QuestionaireQuestionRVO getById(int id);

    public int getCount();

    public int insert(QuestionaireQuestionRVO entity);

    public int delete(int[] ids);

    public int patchCreateQuestions(ArrayList<QuestionaireQuestionRVO> questions);

    public int patchUpdateQuestions(ArrayList<QuestionaireQuestionRVO> questions);
    
    public int patchManageQuestions(ArrayList<QuestionaireQuestionRVO> questionsInEffect);
}
