package com.webdiapp.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionPagination;

@Repository
public interface QuestionDAO {
	
	public int getCount(QuestionPagination question);
    
	public List<Question> getList(QuestionPagination pagination);
    
    public Question getById(String id);
    
    public int insert(Question entity);
    
    public int delete(int id);
    
    public int update(Question entity);
    
} 