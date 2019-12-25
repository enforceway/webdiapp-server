package com.webdiapp.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.entities.QuestionairePagination;

@Repository
public interface QuestionaireDAO {
    
    public List<Questionaire> getList(QuestionairePagination pagination);
    
    public Questionaire getById(int id);
    
    public int getCount(QuestionairePagination pagination);
    
    public int insert(Questionaire entity);
    
    public int delete(int id);
    
    public int update(Questionaire entity);
    
}