package com.webdiapp.questionaire.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.mapper.QuestionaireDAO;
import com.webdiapp.questionaire.service.QuestionaireService;
import com.webdiapp.questionaire.vo.QuestionaireQuestionRVO;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import org.springframework.stereotype.Service;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

    @Override
    public PagingVO<List<QuestionaireVO>> getList(String subject, int pageNO, int size) {
        return null;
    }

    @Override
    public QuestionaireVO getById(Integer id) {
        return null;
    }

    @Override
    public Integer insert(QuestionaireVO que) {
        Date curr = new Date();
        que.setCreationTimestamp(curr);
        que.setLastupdateTimestamp(curr);
        return null;
    }

    @Override
    public Integer delete(int id) {
        return null;
    }

    @Override
    public int deletes(int[] ids) {
        return 0;
    }

    @Override
    public Integer update(QuestionaireVO que) {
        Date curr = new Date();
        que.setLastupdateTimestamp(curr);
        return null;
    }

}
