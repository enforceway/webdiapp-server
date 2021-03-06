package com.webdiapp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.webdiapp.entities.QuestionType;

public interface QuestionTypeDAO {

    public List<QuestionType> getList(@Param("skip") int skip,@Param("size") int size);
    
    public QuestionType getById(int id);
    
    public int getCount();
    
    public int insert(QuestionType entity);
    
    public int delete(int id);
    
    public int update(QuestionType entity);
    
}