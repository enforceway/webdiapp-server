package com.webdiapp.questionaire.service;

import java.util.List;


import com.webdiapp.entities.QuestionType;
import com.webdiapp.entities.User;
import com.webdiapp.questionaire.vo.QuestionOptionRVO;
import com.webdiapp.questions.entities.Question;
import com.webdiapp.questionaire.vo.QuestionaireQuestionRVO;
import com.webdiapp.questionaire.vo.QuestionaireVO;

public interface QuestionaireQuestionService {

    public List<QuestionaireQuestionRVO> getList(int questionaireId);

    public QuestionaireQuestionRVO getById(int id);

    public int getCount();

    public int insert(QuestionaireQuestionRVO entity);

    public int delete(int[] ids);

    interface QuestionaireService {

        List<QuestionaireVO> getList(int pageNO, int size);

        QuestionaireVO getById(Integer id);

        int getCount();

        int insert(QuestionaireVO que);

        int delete(int id);

        int deletes(int[] ids);

        int update(QuestionaireVO que);

    }

    interface QuestionItemOptionService {

        public List<QuestionOptionRVO> getList(int questionItemId);

    //    public Question getById(int id);

        public int getCount();

        public int insert(QuestionOptionRVO entity);

        public int delete(int[] ids);

    }

    interface QuestionsService {

        List<Question> getList(int pageNO, int size);

        Question getById(int id);

        int getCount();

        int insert(Question question);

        int delete(int id);

        int deletes(int[] ids);

        int update(Question Question);

    }

    interface QuestionTypeService {

        List<QuestionType> getList(int pageNO, int size);

        QuestionType getById(int id);

        int getCount();

        int insert(QuestionType que);

        int delete(int id);

        int deletes(int[] ids);

        int update(QuestionType que);

    }

    interface UserService {

        List<User> getList(int pageNO, int size);

        User getById(int id);

        int getCount();

        int insert(User user);

        int delete(int id);

        int deletes(int[] ids);

        int update(User user);

    }
}
