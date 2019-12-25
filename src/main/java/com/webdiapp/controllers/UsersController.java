package com.webdiapp.controllers;

import java.util.Date;
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

import com.webdiapp.entities.User;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.UserAccessService;
import com.webdiapp.services.UserService;
import com.webdiapp.util.JsonUtil;
import com.webdiapp.vo.UserRolesVO;

@RestController
@RequestMapping("/users")
public class UsersController {

	private static final Logger log = Logger.getLogger(UsersController.class);

	@Resource
	UserAccessService userAccessService;

    @Resource
    UserService userService;

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public GeneralResponser<UserRolesVO> listAccessRoles(@RequestBody User user) {
    	return this.userAccessService.listUserAndRole(user);
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public GeneralResponser<Map<String, Object>> login(@RequestBody User user, @RequestParam String redirect,
    		HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		GeneralResponser<Map<String, Object>> res = this.userAccessService.findUserByUserModel(user, session);
		if("".equals(res.getCode())) {
			res.getData().put("location", redirect);
		}
		UsersController.log.info("获取到的用户是:" + JsonUtil.objectToJson(user));
		return res;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<List<User>> list(@RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
    	List<User> list = this.userService.getList(pageNo, pageSize);
        return new GeneralResponser.GeneralSponserBuilder<List<User>>().build(1, "", "", list);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody User user) {
    	Date curr = new Date();
    	user.setCreationTimestamp(curr);
    	user.setLastupdateTimestamp(curr);
    	int count = this.userService.insert(user);
    	return count;
    }

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.POST)
    public GeneralResponser <User> listUserById(@PathVariable("questionId") String strQuestionId) {
    	GeneralResponser.GeneralSponserBuilder<User> builder = new GeneralResponser.GeneralSponserBuilder<User>();
    	User que = null;
    	try {
    		int questionId = Integer.parseInt(strQuestionId);
    		que = this.userService.getById(questionId);
		} catch (NumberFormatException e) {
			return builder.build(0, "00", "该用户ID非法", null);
		}
    	return builder.build(1, "", "", que);
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