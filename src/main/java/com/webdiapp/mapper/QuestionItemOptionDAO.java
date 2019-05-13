package com.webdiapp.mapper;

import java.util.List;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionItemOption;

public interface QuestionItemOptionDAO {

    public List<Question> getList(int questionItemId);
    
//    public Question getById(int id);
    
    public int getCount();
    
    public int insert(QuestionItemOption entity);
    
    public int delete(int[] ids);
    
//    public int update(Question entity);
}
