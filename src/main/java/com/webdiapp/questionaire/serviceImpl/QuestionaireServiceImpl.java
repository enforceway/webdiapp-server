package com.webdiapp.questionaire.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.webdiapp.common.vo.Pagination;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.common.constants.GeneralRemoveStatusEnum;
import com.webdiapp.questionItem.entities.QuestionItemRelationships;
import com.webdiapp.questionItem.mapper.QuestionRelationMapper;
import com.webdiapp.questionItem.vo.QuestionaireQuestionRVO;
import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.mapper.QuestionaireMapper;
import com.webdiapp.questionaire.service.QuestionaireService;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

    @Autowired
    QuestionaireMapper questionaireMapper;

    QuestionRelationMapper relationMapper;

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
            resultList = QuestionaireVO.formatEntityListToVO(list);
        }

        Pagination pagination = new Pagination(pageNO, size, totalCount);
        pagingData.setList(resultList);
        pagingData.setPagination(pagination);
        return pagingData;
    }

    @Override
    public QuestionaireVO getById(Integer id) {
        QuestionaireVO resultVO = new QuestionaireVO();
        resultVO.setQuestionsList(new ArrayList<QuestionaireQuestionRVO>());
        // 查询survey
        List<QuestionItemRelationships> list = this.relationMapper.getQuestionItemList(id);
        for(QuestionItemRelationships relationShip : list) {
            // 设置问卷主键
            resultVO.setId(relationShip.getQuestionaireId());
            // 设置状态
            resultVO.setStatusId(relationShip.getStatusId());
            // 设置起始有效期
            resultVO.setActiveDateStart(relationShip.getActiveDateStart());
            resultVO.setActiveDateEnd(relationShip.getActiveDateEnd());
            // 标题
            resultVO.setTitle(relationShip.getQuestionaireTitle());

            // 追加问卷问题
            QuestionaireQuestionRVO rvo = new QuestionaireQuestionRVO(relationShip);
            resultVO.getQuestionsList().add(rvo);
        }
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
    public GeneralRemoveStatusEnum delete(Integer id) {
        int count = this.questionaireMapper.getCountById(id);
        if (count <= 0) {
            // 不存在
            return GeneralRemoveStatusEnum.NOTEXISTS;
        }

        int result = this.questionaireMapper.delete(id);
        if(result <= 0) {
            // 逻辑删除失败
            return GeneralRemoveStatusEnum.REMOVEFAIL;
        } else {
            // 逻辑删除成功
            return GeneralRemoveStatusEnum.REMOVESUCCESS;
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
