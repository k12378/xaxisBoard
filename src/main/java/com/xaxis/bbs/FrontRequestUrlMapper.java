package com.xaxis.bbs;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class FrontRequestUrlMapper {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * Spring MVC Test �� Servlet Test HelloWorld 
	 * @return
	 */
	@RequestMapping(value="hello.do", method=RequestMethod.GET)
	public String sayHelloWorld(){
		log.debug("HelloWorld");
		return "helloworld";
	}
	
	
	/**
	 * type : function
	 * name : index
	 * description : BoardID �Ķ������ ���� ���η� ������ ���� ���� Front ����  
	 * @param boardID - �Խ��� �ڵ�
	 * @return ModelAndView
	 */
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="BoardID", required=false) String boardID){		
		log.debug("Request Parameter BoardID => " + boardID);		
		if( boardID!=null && !boardID.isEmpty() ){
			/*
				boardID ���� ���� �Ǵ�
				���ų� ���� ���� ���� ��� �����ڷ� �Ǵ�.. ������ �α��� �������� �̵�.
			*/			
			return new ModelAndView("redirect:/board/list.do?BoardID="+ boardID);			
		}else{
			return new ModelAndView("redirect:/admin/index.do");
		}
	}

}
