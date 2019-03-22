package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.Questionaire;

public interface QuestionaireService {

    List<Questionaire> getList(int pageNO, int size);

    Questionaire getById(int id);
    
    int getCount();

    int insert(Questionaire que);

    int delete(int id);

    int deletes(int[] ids);

    int update(Questionaire que);

}