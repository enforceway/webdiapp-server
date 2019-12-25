package com.webdiapp.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

//import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webdiapp.entities.QuestionType;
//import com.webdiapp.vo.QuestionVO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.models.GeneralResponser.GeneralSponserBuilder;
import com.webdiapp.services.QuestionTypeService;

@RestController
@RequestMapping("/questionType")
public class QuestionsTypeController {

//	private static final Logger log = Logger.getLogger(QuestionsTypeController.class);
    
    @Resource
    QuestionTypeService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<List<QuestionType>> list(@PathVariable @RequestParam(required=false,defaultValue="0") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        List<QuestionType> list = this.service.getList(pageNo, pageSize);
        GeneralResponser.GeneralSponserBuilder<List<QuestionType>> builder = new GeneralResponser.GeneralSponserBuilder<List<QuestionType>>();
        return builder.build(1, "", "", list);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody QuestionType que) {
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
//    	que.setUserYn("y");
    	int count = this.service.insert(que);
    	return count;
    }

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser<QuestionType> listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralSponserBuilder<QuestionType> builder = new GeneralSponserBuilder<QuestionType>();
    	QuestionType que = null;
    	try {
    		int questionId = Integer.parseInt(strQuestionId);
    		que = this.service.getById(questionId);
		} catch (NumberFormatException e) {
	    	return builder.build(0, "00", "传入的问题类型id非法", null);
		}
    	return builder.build(1, "", "", que);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes="application/json")
    public int delete(@RequestBody QuestionType que) {
    	int count = this.service.delete(que.getId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public int update(@RequestBody QuestionType que) {
    	Date curr = new Date();
    	que.setLastupdateTimestamp(curr);
    	int count = this.service.update(que);
    	return count;
    }
    
}