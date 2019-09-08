package com.webdiapp.services;

import java.util.List;

import com.webdiapp.vo.QuestionOptionRVO;

public interface QuestionItemOptionService {

    public List<QuestionOptionRVO> getList(int questionItemId);

//    public Question getById(int id);

    public int getCount();

    public int insert(QuestionOptionRVO entity);

    public int delete(int[] ids);
    
    // 根据问卷id，确定了题目。根据题目id, 确定了哪些题目对应的候选项需要删除
    public int removeQuestionItemOptionsByQuestionItemIds(int[] questionIds, int questionaireId);
    
    public int removeQuestionItemsByQuestionId(int[] questionItemIds, int questionId);
    

}
