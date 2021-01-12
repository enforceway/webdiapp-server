package com.webdiapp.questionType.mapper;

import java.util.List;

import com.webdiapp.questionType.entities.QuestionType;
import org.apache.ibatis.annotations.Param;

public interface QuestionTypeDAO {

    public List<QuestionType> getList(@Param("skip") int skip, @Param("size") int size);
    
    public QuestionType getById(int id);
    
    public int getCount();
    
    public int insert(QuestionType entity);
    
    public int delete(int id);
    
    public int update(QuestionType entity);
    
}