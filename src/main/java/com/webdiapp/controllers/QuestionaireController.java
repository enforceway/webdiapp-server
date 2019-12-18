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

import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionaireQuestionService;
import com.webdiapp.services.QuestionaireService;
import com.webdiapp.vo.PagingVO;
import com.webdiapp.vo.QuestionaireQuestionRVO;
import com.webdiapp.vo.QuestionaireVO;

@RestController
@RequestMapping("/questionaire")
public class QuestionaireController {

	private static final Logger log = Logger.getLogger(QuestionaireController.class);
    
    @Resource
    QuestionaireService queService;
    
    @Resource
    QuestionaireQuestionService queQuestionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<PagingVO> list(@RequestParam(required=false) String subject, @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
    	log.info("~~QuestionaireController类, list方法~~~");
    	log.info("pageNo=" + pageNo + ", pageSize=" + pageSize);
    	GeneralResponser<PagingVO> resp = this.queService.getList(subject, pageNo, pageSize);
    	log.info("list方法执行结果:" + resp.getData());
        return resp;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> insert(@RequestBody QuestionaireVO que) {
    	Date curr = new Date();
    	que.setCreationTimestamp(curr);
    	que.setLastupdateTimestamp(curr);
    	GeneralResponser<Integer> resp = this.queService.insert(que);
    	return resp;
    }

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser<QuestionaireVO> listById(@PathVariable("questionId") Integer strQuestionId) {
    	GeneralResponser<QuestionaireVO> gr = this.queService.getById(strQuestionId);
		return gr;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> delete(@RequestBody QuestionaireVO baser) {
    	return this.queService.delete(baser.getId());
    }
    
    @RequestMapping(value = "/deleteItem", method = RequestMethod.PUT, consumes="application/json")
    public GeneralResponser<Integer> deleteQuestion(@RequestBody QuestionaireQuestionRVO rvo) {
    	int[] ids = {rvo.getId()};
    	return this.queQuestionService.delete(ids);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser<Integer> update(@RequestBody QuestionaireVO que) {
    	Date curr = new Date();
    	que.setLastupdateTimestamp(curr);
    	return this.queService.update(que);
    }

}
