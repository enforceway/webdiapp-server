//package com.webdiapp.controllers;
//
//import javax.annotation.Resource;
//
//import org.apache.log4j.Logger;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.webdiapp.entities.Goods;
//import com.webdiapp.services.GoodsService;
//
//@RestController
//@RequestMapping("/goods")
//public class GoodsController {
//
//	private static final Logger log = Logger.getLogger(GoodsController.class);
//    
//    @Resource
//    GoodsService goodsService;
//
//    @RequestMapping("/list")
//    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
//        int size=5;
//        model.addAttribute("size",size);
//        model.addAttribute("pageNO",pageNO);
//        model.addAttribute("count",goodsService.getGoodsCount());
//        model.addAttribute("goods", goodsService.getGoodsPager(pageNO, size));
//        return "goods/list";
//    }
//    
//    @RequestMapping("/listing")
//    public String hello() {
//    	int count = this.goodsService.getGoodsCount();
//    	log.info("search count is:" + count);
//        return "goden/listing:" + count;
//    }
//    
//    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
//    public Goods insert(@RequestBody Goods goods) {
//    	System.out.println(goods.getName() + goods.getSurName());
//    	int count = this.goodsService.getGoodsCount();
//    	log.info("search count is:" + count);
//    	Goods d = new Goods();
//    	d.setName("search count is:" + count);
//        return d;
//    }
//    
//}