package com.webdiapp.services;

import java.util.List;

import com.webdiapp.vo.QuestionOptionRVO;

public interface QuestionItemOptionService {

    public List<QuestionOptionRVO> getList(int questionItemId);

//    public Question getById(int id);

    public int getCount();

    public int insert(QuestionOptionRVO entity);

    public int delete(int[] ids);

}
