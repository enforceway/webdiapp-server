package com.webdiapp.controllers;

import java.util.Date;

import javax.annotation.Resource;

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
    public GeneralResponser list(@RequestParam(required=false) String title, @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        if(pageNo == 0) {
        	pageNo = 1;
        }
        PagingVO questionPaging = this.questionService.getList(title, pageNo, pageSize);
        log.info("问卷查询列表的response是: " + JsonUtil.objectToJson(questionPaging));
        GeneralResponser gr = new GeneralResponser();
        gr.setData(questionPaging);
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody Question que) {
    	log.info("添加题目接口入参: id:" + que.getQuestionTypeId() + 
				";typeid:" + que.getQuestionTypeId() + 
				";type:" + que.getQuestionType());
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
//    	que.setUserYn("y");
    	int count = this.questionService.insert(que);
    	return count;
    }

    @SuppressWarnings("finally")
	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser gr = new GeneralResponser();
    	Question que = null;
    	try {
    		int questionId = Integer.parseInt(strQuestionId);
    		que = this.questionService.getById(questionId);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		} finally {
			gr.setData(que);
			return gr;
		}
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes="application/json")
    public int delete(@RequestBody Question question) {
    	log.info("删除题目接口入参: id:" + question.getQuestionTypeId() + 
				";typeid:" + question.getQuestionTypeId() + 
				";type:" + question.getQuestionType());
    	int count = this.questionService.delete(question.getId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public int update(@RequestBody Question question) {
    	Date curr = new Date();
    	log.info("更新题目接口入参: id:" + question.getQuestionTypeId() +
    							";questionContent:" + question.getQuestionContent() +
    							";typeid:" + question.getQuestionTypeId() + 
    							";type:" + question.getQuestionType());
    	question.setLastupdateTimestamp(curr);
    	int count = this.questionService.update(question);
    	return count;
    }
    
}