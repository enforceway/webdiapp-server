package com.webdiapp.user.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.user.service.UserAccessService;
import com.webdiapp.user.service.UserService;
import com.webdiapp.user.vo.UserRolesVO;
import com.webdiapp.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webdiapp.user.entities.User;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserAccessService userAccessService;

	@Autowired
	UserService userService;

//    @RequestMapping(value = "/roles", method = RequestMethod.POST)
//    public GeneralResponser<UserRolesVO> listAccessRoles(@RequestBody User user) {
//    	return this.userAccessService.listUserAndRole(user);
//    }
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//    public GeneralResponser<Map<String, Object>> login(@RequestBody User user, @RequestParam String redirect,
//    		HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		GeneralResponser<Map<String, Object>> res = this.userAccessService.findUserByUserModel(user, session);
//		if("".equals(res.getCode())) {
//			res.getData().put("location", redirect);
//		}
//		return res;
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<PagingVO<List<UserVO>>> list(@RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
    	GeneralResponser<PagingVO<List<UserVO>>> gr = new GeneralResponser<PagingVO<List<UserVO>>>();
    	if(pageNo <= 0) {
            pageNo = 1;
        }
        if(pageSize <= 0) {
    	    pageSize = 10;
        }
        PagingVO<List<UserVO>> pagingData = this.userService.getList(pageNo, pageSize);
        gr.setData(pagingData);
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody UserVO userVO) {
    	int count = this.userService.insert(userVO);
    	return count;
    }

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.POST)
    public GeneralResponser<UserVO> listUserById(@PathVariable("questionId") String strQuestionId) {
        GeneralResponser<UserVO>  gr = new GeneralResponser<UserVO>();
    	UserVO que = this.userService.getById(strQuestionId);
        gr.setData(que);
    	return gr;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes="application/json")
    public int delete(@RequestBody User user) {
    	int count = this.userService.delete(user.getId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes="application/json")
    public int update(@RequestBody UserVO userVO) {
    	int count = this.userService.update(userVO);
    	return count;
    }
    
}