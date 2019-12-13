package com.webdiapp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.webdiapp.entities.QuestionType;

@Repository
public interface QuestionTypeDAO {

    public List<QuestionType> getList(@Param("skip") int skip,@Param("size") int size);
    
    public QuestionType getById(int id);
    
    public int getCount();
    
    public int insert(QuestionType entity);
    
    public int delete(int id);
    
    public int update(QuestionType entity);
    
}