package com.webdiapp.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.webdiapp.services.UserAccessService;
import com.webdiapp.services.UserService;
import com.webdiapp.vo.UserRolesVO;

@RestController
@RequestMapping("/users")
@SessionAttributes("users")
public class UsersController {

	private static final Logger log = Logger.getLogger(UsersController.class);

	@Resource
	UserAccessService userAccessService;

    @Resource
    UserService userService;

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public GeneralResponser<UserRolesVO> listAccessRoles(@RequestBody User user) {
    	return this.userAccessService.listRoleByUser(user);
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public GeneralResponser<Map<String, String>> login(@RequestBody User user, @RequestParam String redirect,
    		HttpServletRequest request, HttpServletResponse response) {
		GeneralResponser.GeneralSponserBuilder<Map<String, String>> builder = new GeneralResponser.GeneralSponserBuilder<Map<String, String>>();
		GeneralResponser<Map<String, String>> result = null;
		Map<String, String> userResult = null;
		HttpSession session = request.getSession();
		user = this.userAccessService.findUserByUserModel(user);
		if(user == null) {
			// 如果找到了多个该用户, 即该用户是脏数据
			result = builder.build(1, "00", "查询用户角色出现错误：根据用户名和密码，不应该查询到两个用户结果");
		} else if(user.getId() == null) {
			// 如果该用户在数据库中不存在
			result = builder.build(1, "00", "该用户还未注册");
		} else {
			userResult = new HashMap<String, String>();
			result = builder.build(1, "", "", userResult);
			// 用户信息保存在session中
			session.setAttribute(CommonConstants.LOGIN_SESSION_KEY, user);
			try {
				redirect = URLDecoder.decode(redirect, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				redirect = "";
			} finally {
				userResult.put("location", redirect);
			}
		}
		return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<List<User>> list(@RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
    	List<User> list = this.userService.getList(pageNo, pageSize);
        return new GeneralResponser.GeneralSponserBuilder<List<User>>().build(1, "", "", list);
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