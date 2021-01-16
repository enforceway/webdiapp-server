package com.webdiapp.roleAccess.controllers;

import java.util.List;

import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.roleAccess.entities.Role;
import com.webdiapp.roleAccess.service.RoleService;
import com.webdiapp.roleAccess.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
    RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GeneralResponser<PagingVO<List<RoleVO>>> list(@RequestParam(required=false,defaultValue="1") int pageNo, @RequestParam(required=false, defaultValue="10") int pageSize){
    	GeneralResponser<PagingVO<List<RoleVO>>> gr = new GeneralResponser<PagingVO<List<RoleVO>>>();
    	if(pageNo <= 0) {
            pageNo = 1;
        }
        if(pageSize <= 0) {
    	    pageSize = 10;
        }
        PagingVO<List<RoleVO>> pagingData = this.roleService.getList(pageNo, pageSize);
        gr.setData(pagingData);
        return gr;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
    public int insert(@RequestBody RoleVO roleVO) {
    	int count = this.roleService.insert(roleVO);
    	return count;
    }

	@RequestMapping(value = "/list/{roleId}", method = RequestMethod.GET)
    public GeneralResponser<RoleVO> listUserById(@PathVariable("roleId") String roleId) {
        GeneralResponser gr = new GeneralResponser<RoleVO>();
        gr.setData(null);
        try {
            Integer id = Integer.valueOf(roleId);
            RoleVO que = this.roleService.getById(id);
            gr.setData(que);
        } catch(NumberFormatException e) {
            gr.setData(e.getMessage());
        } finally {

        }
    	return gr;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes="application/json")
    public int delete(@RequestBody Role user) {
    	int count = this.roleService.delete(user.getRoleId());
        return count;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes="application/json")
    public int update(@RequestBody RoleVO roleVO) {
    	int count = this.roleService.update(roleVO);
    	return count;
    }
    
}