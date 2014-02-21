package com.xaxis.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@RequestMapping(value="/")
	public String getBoardItemList(@RequestParam(value="boardCode", required=true, defaultValue="test") String boardCode,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		
		model.addAttribute("boardCode", boardCode);
				
		return "index";
	}
	
	@RequestMapping(value="/admin/")
	public String adminLayout(){
		return "admin/index";
	}
}
