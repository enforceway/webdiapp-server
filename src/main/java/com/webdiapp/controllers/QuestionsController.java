package com.webdiapp.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webdiapp.entities.Goods;
import com.webdiapp.entities.Question;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

	private static final Logger log = Logger.getLogger(GoodsController.class);
    
    @Resource
    QuestionsService questionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser list(@RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
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
    public Goods insert(@RequestBody Goods goods) {
    	System.out.println(goods.getName() + goods.getSurName());
    	int count = this.questionService.getCount();
    	log.info("search count is:" + count);
    	Goods d = new Goods();
    	d.setName("search count is:" + count);
        return d;
    }
    
}