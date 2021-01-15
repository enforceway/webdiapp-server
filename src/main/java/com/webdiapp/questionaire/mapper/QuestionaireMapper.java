package com.webdiapp.questionaire.mapper;

import java.util.List;

import com.webdiapp.questionaire.entities.Questionaire;
import org.apache.ibatis.annotations.Param;

public interface QuestionaireMapper {
    
    public List<Questionaire> getList(@Param("title") String title, @Param("skip") int skip, @Param("size") int size);
    
    public Questionaire getById(int id);
    
    public int getCount(@Param("title") String title);

    public int getCountById(@Param("id") Integer id);
    
    public int insert(Questionaire entity);
    
    public int delete(Integer id);
    
    public int update(Questionaire entity);
    
}
