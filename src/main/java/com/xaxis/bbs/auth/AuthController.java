package com.xaxis.bbs.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login/")
public class AuthController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"", "login"}, method=RequestMethod.GET)
	public ModelAndView goLogin(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="redirectUrl", required=false) String redirectUrl)
	{
		log.debug("redirectURL => "+ redirectUrl);
		if( redirectUrl == null ){
			redirectUrl = "/";
			if( request.getHeader("Referer") != null && !request.getHeader("Referer").isEmpty() ){
				redirectUrl = request.getHeader("Referer");
			}
		}
		
		model.addAttribute("redirectUrl", redirectUrl);
		
		return new ModelAndView("login");
	}
}
