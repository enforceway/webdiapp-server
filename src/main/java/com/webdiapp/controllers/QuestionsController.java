package com.webdiapp.controllers;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webdiapp.entities.Question;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionsService;
import com.webdiapp.util.JsonUtil;
import com.webdiapp.vo.PagingVO;

@RestController
@RequestMapping("/question")
public class QuestionsController {

	private static final Logger log = Logger.getLogger(QuestionsController.class);
    
    @Resource
    QuestionsService questionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<PagingVO> list(HttpSession session, @RequestParam(required=false) String title, @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        GeneralResponser<PagingVO> gr = this.questionService.getList(title, pageNo, pageSize);
        log.info("问卷查询列表的response是: " + JsonUtil.objectToJson(gr.getData()));
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> insert(@RequestBody Question que) {
    	log.info("添加题目接口入参: id:" + que.getQuestionTypeId() + 
				";typeid:" + que.getQuestionTypeId() + 
				";type:" + que.getQuestionType());
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
//    	que.setUserYn("y");
    	return this.questionService.insert(que);
    }

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser<Question> listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser<Question> qre = null;
		qre = this.questionService.getById(strQuestionId);
    	return qre;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> delete(@RequestBody Question question) {
    	log.info("删除题目接口入参: id:" + question.getQuestionTypeId() + 
				";typeid:" + question.getQuestionTypeId() + 
				";type:" + question.getQuestionType());
    	return this.questionService.delete(question.getId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> update(@RequestBody Question question) {
    	Date curr = new Date();
    	log.info("更新题目接口入参: id:" + question.getQuestionTypeId() +
    							";questionContent:" + question.getQuestionContent() +
    							";typeid:" + question.getQuestionTypeId() + 
    							";type:" + question.getQuestionType());
    	question.setLastupdateTimestamp(curr);
    	return this.questionService.update(question);
    }
    
}