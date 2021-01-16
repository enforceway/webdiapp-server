package com.webdiapp.question.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

//import org.apache.log4j.Logger;
import com.webdiapp.common.constants.GeneralRemoveStatusEnum;
import com.webdiapp.common.constants.GeneralResponseStatusEnum;
import com.webdiapp.question.vo.QuestionVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webdiapp.common.constants.CommonConstants;
import com.webdiapp.question.entities.Question;
import com.webdiapp.user.entities.User;
import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.question.service.QuestionService;
//import com.webdiapp.common.util.JsonUtil;
import com.webdiapp.common.vo.PagingVO;

@RestController
@RequestMapping("/question")
public class QuestionController {

//	private static final Logger log = Logger.getLogger(QuestionsController.class);
    
    @Resource
    QuestionService questionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<PagingVO> list(@RequestParam(required=false) String title, 
    				@RequestParam(required=false,defaultValue="1") int pageNo,
    				@RequestParam(required=false, defaultValue="10") int pageSize) {
		if(pageNo <= 0) {
			pageNo = 1;
		}
        if(pageSize == 0) {
            pageSize = 10;
        }
        PagingVO<List<QuestionVO>> list = this.questionService.getList(title, pageNo, pageSize);
        GeneralResponser<PagingVO> gr = new GeneralResponser<PagingVO>();
        gr.setData(list);
//        log.info("问卷查询列表的response是: " + JsonUtil.objectToJson(gr.getData()));
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> insert(@RequestBody Question que) {
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
//    	que.setUserYn("y");
    	return this.questionService.insert(que);
    }

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser<QuestionVO> listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser<QuestionVO> qre = new GeneralResponser<QuestionVO>();
        QuestionVO que = this.questionService.getById(strQuestionId);
        qre.setData(que);
    	return qre;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes="application/json")
    public GeneralResponser<Integer> delete(@RequestBody Question question) {
        GeneralResponser<Integer> gr = new GeneralResponser<Integer>();
        GeneralRemoveStatusEnum removeStatus = this.questionService.delete(question.getId());
        gr.setData(removeStatus.enumToInt());
        if(removeStatus == GeneralRemoveStatusEnum.REMOVESUCCESS) {
            gr.setCode(GeneralResponseStatusEnum.CODESUCCESS.enumToString());
        } else {
            gr.setCode(GeneralResponseStatusEnum.CODEFAIL.enumToString());
        }
    	return gr;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> update(@RequestBody Question question) {
    	Date curr = new Date();
    	question.setLastupdateTimestamp(curr);
    	return this.questionService.update(question);
    }
    
}