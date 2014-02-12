package com.xaxis.bbs.group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xaxis.bbs.BaseController;
import com.xaxis.bbs.model.Group;

@Controller
@RequestMapping("/group/")
public class GroupController implements BaseController{
	
	@Autowired
	private GroupService groupService;
	
	@Override
	@RequestMapping(value="list/", method=RequestMethod.GET)
	public ModelAndView getListAll() {
		// TODO Auto-generated method stub
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		List<Group> groupList = groupService.getGroupAllList();
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", groupList);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	@RequestMapping(value="item/{groupID}/", method=RequestMethod.GET)
	public ModelAndView getGroupItem(@PathVariable("groupID") int groupID){
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		Group group = groupService.getGroupItem(groupID);
		
		if( group != null && !group.getGroupName().isEmpty() ){
			responseData.put("result", BaseController.SUCCESS_MESSAGE);
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
		}
		
		responseData.put("resultData", group);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	@RequestMapping(value="item/update/{groupID}/", method=RequestMethod.POST)
	public ModelAndView UpdateGroupItem(@PathVariable("groupID") int groupID,
			@RequestParam(value="groupName", required=true) String groupName,
			@RequestParam(value="register", required=true) String register){
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		Group group = groupService.getGroupItem(groupID);
		if( group != null ){
			Group groupParam = new Group(groupID, groupName, register);			
			groupService.updateGroupItem(groupParam);
			responseData.put("result", BaseController.SUCCESS_MESSAGE);			
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
		}
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	
	
	
	@Override
	public ModelAndView getList(int currentPage, int paseSize,
			String searchField, String searchKeyword, String descField,
			String descCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
