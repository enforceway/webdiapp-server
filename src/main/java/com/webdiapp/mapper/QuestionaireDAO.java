package com.webdiapp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.webdiapp.entities.Questionaire;

public interface QuestionaireDAO {
    
    public List<Questionaire> getList(@Param("skip") int skip,@Param("size") int size);
    
    public Questionaire getById(int id);
    
    public int getCount();
    
    public int insert(Questionaire entity);
    
    public int delete(int id);
    
    public int update(Questionaire entity);
    
}