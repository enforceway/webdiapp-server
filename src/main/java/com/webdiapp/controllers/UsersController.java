package com.webdiapp.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webdiapp.constants.CommonConstants;
import com.webdiapp.entities.User;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.UserService;

@RestController
@RequestMapping("/users")
@SessionAttributes("users")
public class UsersController {

	private static final Logger log = Logger.getLogger(UsersController.class);
    
    @Resource
    UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public GeneralResponser<String> login(@RequestBody User user, @RequestParam String redirect,
    		HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.setAttribute(CommonConstants.LOGIN_SESSION_KEY, user);
        GeneralResponser.GeneralSponserBuilder<String> builder = new GeneralResponser.GeneralSponserBuilder<String>();
        log.info("user.username:" + user.getUsername() + ", user.pwd:" + user.getPwd());
        try {
			redirect = URLDecoder.decode(redirect, "UTF-8");
//			System.out.println("redirect:" + redirect);
//			response.sendRedirect(redirect);
//			return builder.build(1, "", "", redirect);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return builder.build(1, "", "", redirect);
    }

    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    public GeneralResponser list(@PathVariable @RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
        List<User> list = this.userService.getList(pageNo, pageSize);
        GeneralResponser gr = new GeneralResponser();
        gr.setData(list);
        return gr;
    }

    @RequestMapping("/listing")
    public String hello() {
    	int count = this.userService.getCount();
    	log.info("search count is:" + count);
        return "goden/listing:" + count;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody User user) {
    	Date curr = new Date();
    	user.setCreationTimestamp(curr);
    	user.setLastupdateTimestamp(curr);
//    	user.setUserYn("y");
    	int count = this.userService.insert(user);
    	return count;
    }

    @SuppressWarnings("finally")
	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
    public GeneralResponser listById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser gr = new GeneralResponser();
    	User que = null;
    	try {
    		int questionId = Integer.parseInt(strQuestionId);
    		que = this.userService.getById(questionId);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		} finally {
			gr.setData(que);
			return gr;
		}
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes="application/json")
    public int delete(@RequestBody User user) {
    	int count = this.userService.delete(user.getId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes="application/json")
    public int update(@RequestBody User user) {
    	Date curr = new Date();
    	user.setLastupdateTimestamp(curr);
    	int count = this.userService.update(user);
    	return count;
    }
    
}