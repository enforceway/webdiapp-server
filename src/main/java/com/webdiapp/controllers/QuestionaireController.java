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

import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionaireQuestionService;
import com.webdiapp.services.QuestionaireService;
import com.webdiapp.vo.QuestionaireQuestionRVO;
import com.webdiapp.vo.QuestionaireVO;

@RestController
@RequestMapping("/questionaire")
public class QuestionaireController {

//	private static final Logger log = Logger.getLogger(QuestionaireController.class);
    
    @Resource
    QuestionaireService queService;
    
    @Resource
    QuestionaireQuestionService queQuestionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser list(@PathVariable @RequestParam(required=false,defaultValue="0") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        List<QuestionaireVO> list = this.queService.getList(pageNo, pageSize);
        GeneralResponser gr = new GeneralResponser();
        gr.setData(list);
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser insert(@RequestBody QuestionaireVO que) {
    	GeneralResponser gr = new GeneralResponser();
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
    	Integer ifSucc = this.queService.insert(que);
    	gr.setData(ifSucc);
    	return gr;
    }

    @SuppressWarnings("finally")
	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser listById(@PathVariable("questionId") Integer strQuestionId) {
    	GeneralResponser gr = new GeneralResponser();
    	QuestionaireVO que = null;
    	try {
    		que = this.queService.getById(strQuestionId);
		} catch (NumberFormatException e) {
			gr.setData(e.getMessage());
		} finally {
			gr.setData(que);
			return gr;
		}
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes="application/json")
    public int delete(@RequestBody QuestionaireVO baser) {
    	int count = this.queService.delete(baser.getId());
        return count;
    }
    
    @RequestMapping(value = "/deleteItem", method = RequestMethod.PUT, consumes="application/json")
    public int deleteQuestion(@RequestBody QuestionaireQuestionRVO rvo) {
    	int[] ids = {rvo.getId()};
    	int count = this.queQuestionService.delete(ids);
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public int update(@RequestBody QuestionaireVO que) {
    	Date curr = new Date();
    	que.setLastupdateTimestamp(curr);
    	int count = this.queService.update(que);
    	return count;
    }

}
