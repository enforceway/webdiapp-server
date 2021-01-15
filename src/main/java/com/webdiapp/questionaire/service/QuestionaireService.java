package com.webdiapp.questionaire.service;

import com.webdiapp.questionaire.constants.QuestionaireRemoveStatus;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import com.webdiapp.common.vo.Pagination;
import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.PagingVO;

import java.util.List;

public interface QuestionaireService {
    // 按条件分页查询
	PagingVO<List<QuestionaireVO>> getList(String subject, int pageNO, int size);
    // 按照主键查询
	QuestionaireVO getById(Integer id);
    // 新增新数据
    Integer insert(QuestionaireVO que);
    // 按照主键删除数据
    QuestionaireRemoveStatus delete(Integer id);
    // 按照主键熟知删除数据
    int deletes(int[] ids);
    // 更新数据
    Integer update(QuestionaireVO que);

}
