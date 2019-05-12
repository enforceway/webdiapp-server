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
import com.webdiapp.vo.QuestionaireVO;

@RestController
@RequestMapping("/questionaire")
public class QuestionaireController {

	private static final Logger log = Logger.getLogger(QuestionaireController.class);
    
    @Resource
    QuestionaireService queService;

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
    	Integer ifSucc = 0;
    	try {
    		ifSucc = this.queService.insert(que);
		} catch (NumberFormatException e) {
//			ifSucc = 0;
		} finally {
			gr.setData(ifSucc);
			return gr;
		}
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
