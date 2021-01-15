package com.webdiapp.questionaire.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.Pagination;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.questionaire.constants.QuestionaireRemoveStatus;
import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.mapper.QuestionaireMapper;
import com.webdiapp.questionaire.service.QuestionaireService;
import com.webdiapp.questionaire.vo.QuestionaireQuestionRVO;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

    @Autowired
    QuestionaireMapper questionaireMapper;

    @Override
    public PagingVO<List<QuestionaireVO>> getList(String title, int pageNO, int size) {
        PagingVO<List<QuestionaireVO>> pagingData = new PagingVO<List<QuestionaireVO>>();

        List<Questionaire> list = null;
        List<QuestionaireVO> resultList = new ArrayList<QuestionaireVO>();

        int totalCount = this.questionaireMapper.getCount(title);
        if (totalCount > 0) {
          int npageNo = size * (pageNO - 1);
          list = this.questionaireMapper.getList(title, npageNo, size);
        } else {
          pageNO = 0;
        }
        if (list != null) {
            resultList= QuestionaireVO.formatEntityListToVO(list);
        }

        Pagination pagination = new Pagination(pageNO, size, totalCount);
        pagingData.setList(resultList);
        pagingData.setPagination(pagination);
        return pagingData;
    }

    @Override
    public QuestionaireVO getById(Integer id) {
        Questionaire result = this.questionaireMapper.getById(id);
        QuestionaireVO resultVO = new QuestionaireVO(result);
        return resultVO;
    }

    @Override
    public Integer insert(QuestionaireVO que) {
        Date curr = new Date();
        que.setCreationTimestamp(curr);
        que.setLastupdateTimestamp(curr);
        return null;
    }

    @Override
    public QuestionaireRemoveStatus delete(Integer id) {
        int count = this.questionaireMapper.getCountById(id);
        if (count <= 0) {
            // 不存在
            return QuestionaireRemoveStatus.NOTEXISTS;
        }

        int result = this.questionaireMapper.delete(id);
        if(result <= 0) {
            // 逻辑删除失败
            return QuestionaireRemoveStatus.REMOVEFAIL;
        } else {
            // 逻辑删除成功
            return QuestionaireRemoveStatus.REMOVESUCCESS;
        }
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
