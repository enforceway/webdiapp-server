package com.webdiapp.questions.mapper;

import com.webdiapp.questions.entities.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDAO {
    
    public List<Question> getList(@Param("skip") int skip, @Param("size") int size);
    
    public Question getById(int id);
    
    public int getCount();
    
    public int insert(Question entity);
    
    public int delete(int id);
    
    public int update(Question entity);
    
}