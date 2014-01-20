package com.xaxis.bbs.helloworld;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("hello.do")
	public String helloWorld(){
		log.debug("HelloWorldController");
		return "helloworld";
	}
	
	/**
	 * type : function
	 * name : index
	 * description : BoardID 파라미터의 존재 여부로 관리자 구분 할지 Front 구분  
	 * @param boardID - 게시판 코드
	 * @return ModelAndView
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="BoardID", required=false) String boardID){		
		log.debug("Request Parameter BoardID => " + boardID);		
		if( boardID!=null && !boardID.isEmpty() ){
			
//				boardID 존재 여부 판단
//				없거나 존재 하지 않을 경우 관리자로 판단.. 관리자 로그인 페이지로 이동.
						
			return new ModelAndView("redirect:/board/list.do?BoardID="+ boardID);			
		}else{
			return new ModelAndView("redirect:/admin/index.do");
		}
	}
*/
}
