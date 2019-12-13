package com.webdiapp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.webdiapp.entities.Question;

@Repository
public interface QuestionDAO {
	
	public int getCount(@Param("content") String questionName);
    
	public List<Question> getList(@Param("content") String questionName, @Param("startIndex") int skip, @Param("pageSize") int size);
    
    public Question getById(String id);
    
    public int insert(Question entity);
    
    public int delete(int id);
    
    public int update(Question entity);
    
}