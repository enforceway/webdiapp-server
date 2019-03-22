package com.webdiapp.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webdiapp.entities.Question;
import com.webdiapp.vo.QuestionVO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

	private static final Logger log = Logger.getLogger(GoodsController.class);
    
    @Resource
    QuestionsService questionService;

    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    public GeneralResponser list(@PathVariable @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        System.out.println(pageNo + "," + pageSize);
        List<Question> list = this.questionService.getList(pageNo, pageSize);
        GeneralResponser gr = new GeneralResponser();
        gr.setData(list);
        return gr;
    }
    
    @RequestMapping("/listing")
    public String hello() {
    	int count = this.questionService.getCount();
    	log.info("search count is:" + count);
        return "goden/listing:" + count;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody Question question) {
    	System.out.println("insert for questions:" + question.getQuestionContent() + ", " + question.getQuestionType() + "," + question.getCreationTimestamp());
    	Date curr = new Date();
    	question.setCreationTimestamp(curr);
    	question.setLastupdateTimestamp(curr);
    	int count = this.questionService.insert(question);
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
    
    @RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes="application/json")
    public int delete(@RequestBody Question question) {
    	int count = this.questionService.delete(question.getId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public int update(@RequestBody Question question) {
    	Date curr = new Date();
    	question.setLastupdateTimestamp(curr);
    	int count = this.questionService.update(question);
    	return count;
    }
    
}