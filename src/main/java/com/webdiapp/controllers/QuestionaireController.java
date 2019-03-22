package com.webdiapp.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionaireService;

@RestController
@RequestMapping("/questionaire")
public class QuestionaireController {

	private static final Logger log = Logger.getLogger(QuestionaireController.class);
    
    @Resource
    QuestionaireService queService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser list(@PathVariable @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        System.out.println(pageNo + "," + pageSize);
        List<Questionaire> list = this.queService.getList(pageNo, pageSize);
        GeneralResponser gr = new GeneralResponser();
        gr.setData(list);
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody Questionaire que) {
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
    	que.setUserYn("y");
    	System.out.println("vo from questionaire controller is:" + que.getStatus() + "," + que.getStatusId() + "," + que.getWorkingField());
    	int count = this.queService.insert(que);
    	return count;
    }

    @SuppressWarnings("finally")
	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser gr = new GeneralResponser();
    	Questionaire que = null;
    	try {
    		int questionId = Integer.parseInt(strQuestionId);
    		que = this.queService.getById(questionId);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		} finally {
			gr.setData(que);
			return gr;
		}
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes="application/json")
    public int delete(@RequestBody Questionaire que) {
    	int count = this.queService.delete(que.getId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public int update(@RequestBody Questionaire que) {
    	Date curr = new Date();
    	que.setLastupdateTimestamp(curr);
    	int count = this.queService.update(que);
    	return count;
    }

}
