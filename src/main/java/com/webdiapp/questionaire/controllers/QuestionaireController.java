package com.webdiapp.questionaire.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

//import org.apache.log4j.Logger;
import com.webdiapp.common.constants.GeneralResponseStatusEnum;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.common.constants.GeneralRemoveStatusEnum;
import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.service.QuestionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.questionaire.vo.QuestionaireVO;

@RestController
@RequestMapping("/questionaire")
public class QuestionaireController {

//	private static final Logger log = Logger.getLogger(QuestionaireController.class);
    
    @Autowired
	QuestionaireService queService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser list(@RequestParam(required = false,defaultValue = "") String surveyTitle, @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        if(pageNo <= 0) {
            pageNo = 1;
        }
        if(pageSize == 0) {
            pageSize = 10;
        }
        PagingVO<List<QuestionaireVO>> list = this.queService.getList(surveyTitle, pageNo, pageSize);
        GeneralResponser<PagingVO> gr = new GeneralResponser<PagingVO>();
        gr.setData(list);
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public GeneralResponser insert(@RequestBody QuestionaireVO que) {
    	Integer ifSucc = this.queService.insert(que);
        GeneralResponser gr = new GeneralResponser();
    	gr.setData(ifSucc);
    	return gr;
    }

//    @SuppressWarnings("finally")
	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser gr = new GeneralResponser();
    	QuestionaireVO que = null;
    	try {
    	    Integer queId = Integer.valueOf(strQuestionId);
    		que = this.queService.getById(queId);
            gr.setData(que);
    		return gr;
		} catch (NumberFormatException e) {
    	    e.printStackTrace();
			gr.setData(e.getMessage());
		} catch(Exception e) {
    	    e.printStackTrace();
    	    gr.setData(e.getMessage());
        } finally {
			gr.setData(que);
			return gr;
		}
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes="application/json")
    public GeneralResponser<Integer> delete(@RequestBody Questionaire que) {
        GeneralResponser<Integer> gr = new GeneralResponser<Integer>();
        GeneralRemoveStatusEnum removeStatus = this.queService.delete(que.getId());
        gr.setData(removeStatus.enumToInt());
        if(removeStatus == GeneralRemoveStatusEnum.REMOVESUCCESS) {
            gr.setCode(GeneralResponseStatusEnum.CODESUCCESS.enumToString());
        } else {
            gr.setCode(GeneralResponseStatusEnum.CODEFAIL.enumToString());
        }
        return gr;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes="application/json")
    public int update(@RequestBody QuestionaireVO que) {
    	int count = this.queService.update(que);
    	return count;
    }

}
