package com.webdiapp.question.mapper;

import java.util.List;

import com.webdiapp.question.entities.Question;
import com.webdiapp.question.entities.QuestionPagination;
import org.springframework.stereotype.Repository;

public interface QuestionMapper {

	public int getCount(Question question);
    
	public List<Question> getList(QuestionPagination question);
    
    public Question getById(String id);
    
    public int insert(Question entity);
    
    public int delete(int id);
    
    public int update(Question entity);
    
} 