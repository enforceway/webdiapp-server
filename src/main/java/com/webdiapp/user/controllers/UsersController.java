//package com.webdiapp.controllers;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.apache.log4j.Logger;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.webdiapp.entities.User;
//import com.webdiapp.models.GeneralResponser;
//import com.webdiapp.questionaire.service.QuestionaireQuestionService.UserService;
//
//@RestController
//@RequestMapping("/users")
//public class UsersController {
//
//	private static final Logger log = Logger.getLogger(UsersController.class);
//
//    @Resource
//    UserService userService;
//
//    @RequestMapping(value = "/list/", method = RequestMethod.GET)
//    public GeneralResponser list(@PathVariable @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
//        System.out.println(pageNo + "," + pageSize);
//        List<User> list = this.userService.getList(pageNo, pageSize);
//        GeneralResponser gr = new GeneralResponser();
//        gr.setData(list);
//        return gr;
//    }
//
//    @RequestMapping("/listing")
//    public String hello() {
//    	int count = this.userService.getCount();
//    	log.info("search count is:" + count);
//        return "goden/listing:" + count;
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
//    public int insert(@RequestBody User user) {
//    	System.out.println("insert for questions:" + user.getUsername());// + ", " + user.getQuestionType() + "," + user.getCreationTimestamp());
//    	Date curr = new Date();
//    	user.setCreationTimestamp(curr);
//    	user.setLastupdateTimestamp(curr);
////    	user.setUserYn("y");
//    	int count = this.userService.insert(user);
//    	return count;
//    }
//
//    @SuppressWarnings("finally")
//	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
//    public GeneralResponser listById(@PathVariable("questionId") String strQuestionId) {
//    	GeneralResponser gr = new GeneralResponser();
//    	User que = null;
//    	try {
//    		int questionId = Integer.parseInt(strQuestionId);
//    		que = this.userService.getById(questionId);
//		} catch (NumberFormatException e) {
//			// TODO: handle exception
//		} finally {
//			gr.setData(que);
//			return gr;
//		}
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes="application/json")
//    public int delete(@RequestBody User user) {
//    	int count = this.userService.delete(user.getId());
//        return count;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes="application/json")
//    public int update(@RequestBody User user) {
//    	Date curr = new Date();
//    	user.setLastupdateTimestamp(curr);
//    	int count = this.userService.update(user);
//    	return count;
//    }
//
//}