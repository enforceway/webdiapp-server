package com.webdiapp.services;

import java.util.List;
import com.webdiapp.entities.Question;
import com.webdiapp.entities.User;

public interface UserService {

    List<Question> getList(int pageNO, int size);

    Question getById(int id);
    
    int getCount();

    int insert(User user);

    int delete(int id);

    int deletes(int[] ids);

    int update(User user);

}