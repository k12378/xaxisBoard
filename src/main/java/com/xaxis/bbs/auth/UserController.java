package com.xaxis.bbs.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xaxis.bbs.BaseController;
import com.xaxis.bbs.model.UserInfo;

@Controller
@RequestMapping("/user/")
public class UserController implements BaseController{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="{user_id}/", method=RequestMethod.GET)
	public ModelAndView getUserInfo(@PathVariable("user_id") String userID)
	{
		
		UserInfo user = userService.getUserInfo(userID);
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		if( user.getUserID().equals("rmkdev") ){
			responseData.put("result", BaseController.SUCCESS_MESSAGE);
			responseData.put("resultData", user);
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
		}
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	
	@Override
	@RequestMapping(value="list/", method=RequestMethod.GET)
	public ModelAndView getListAll() {
		// TODO Auto-generated method stub
		List<UserInfo> userList = userService.getUserAllList();
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", userList);
		
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
