package com.xaxis.bbs.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xaxis.bbs.BaseController;
import com.xaxis.bbs.auth.UserService;
import com.xaxis.bbs.model.BoardConfig;
import com.xaxis.bbs.model.Message;

@Controller
@RequestMapping("/board/")
public class BoardController implements BaseController{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 게시판 설정 조회
	 * @param boardCode
	 * @return
	 */
	@RequestMapping(value="item/{boardCode}/")
	public ModelAndView getBoardList(@PathVariable("boardCode") String boardCode){
		
		log.debug("boardCode => "+ boardCode);
		
		BoardConfig boardConfig = boardService.getBoardConfig(boardCode);
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", boardConfig);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 게시판 모든 리스트 조회
	 * @return
	 */
	@Override
	@RequestMapping(value="list/")
	public ModelAndView getListAll() {
		// TODO Auto-generated method stub
		List<BoardConfig> boardConfigList = boardService.getBoardConfigList();
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", boardConfigList);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 게시판 설정 삭제
	 * @param boardCode
	 * @return
	 */
	@RequestMapping(value="{boardCode}/delete/")
	public ModelAndView deleteBoardConfig(@PathVariable("boardCode") String boardCode){
		
		boardService.deleteBoard(boardCode);
		
		Map<String, Object> responseData = new HashMap<String, Object>();		
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 게시판 설정 수정
	 * @param boardCode
	 * @param categoryCode
	 * @param typeCode
	 * @param adminFlag
	 * @param replyFlag
	 * @param commentFlag
	 * @param attchementFlag
	 * @param secretFlag
	 * @param recommendanteFlag
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="{boardCode}/update/", method=RequestMethod.POST)
	public ModelAndView updateBoardConfig(@PathVariable("boardCode") String boardCode,
			@RequestParam(value="categoryCode", required=true) int categoryCode,
			@RequestParam(value="typeCode", required=true, defaultValue="1") String typeCode,
			@RequestParam(value="adminFlag", required=false, defaultValue="0") int adminFlag,
			@RequestParam(value="replyFlag", required=false, defaultValue="0") int replyFlag,
			@RequestParam(value="commentFlag", required=false, defaultValue="0") int commentFlag,
			@RequestParam(value="attchementFlag", required=false, defaultValue="0") int attchementFlag,
			@RequestParam(value="secretFlag", required=false, defaultValue="0") int secretFlag,
			@RequestParam(value="recommendateFlag", required=false, defaultValue="0") int recommendanteFlag,
			@RequestParam(value="userId", required=true) String userID
			){
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		BoardConfig conf = new BoardConfig(boardCode, 
				categoryCode, 
				typeCode, 
				adminFlag, 
				replyFlag, 
				commentFlag, 
				attchementFlag, 
				secretFlag, 
				recommendanteFlag);
		
		if( userService.isUser(userID) ){
			conf.setUpdater(userID);
			boardService.updateBoard(conf);
			responseData.put("result", BaseController.SUCCESS_MESSAGE);
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
		}		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 게시판 설정 등록
	 * @param boardCode
	 * @param categoryCode
	 * @param typeCode
	 * @param adminFlag
	 * @param replyFlag
	 * @param commentFlag
	 * @param attchementFlag
	 * @param secretFlag
	 * @param recommendanteFlag
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="add/", method=RequestMethod.POST)
	public ModelAndView addBoardConfig(@RequestParam("boardCode") String boardCode,
			@RequestParam(value="categoryCode", required=true) int categoryCode,
			@RequestParam(value="typeCode", required=true, defaultValue="1") String typeCode,
			@RequestParam(value="adminFlag", required=false, defaultValue="0") int adminFlag,
			@RequestParam(value="replyFlag", required=false, defaultValue="0") int replyFlag,
			@RequestParam(value="commentFlag", required=false, defaultValue="0") int commentFlag,
			@RequestParam(value="attchementFlag", required=false, defaultValue="0") int attchementFlag,
			@RequestParam(value="secretFlag", required=false, defaultValue="0") int secretFlag,
			@RequestParam(value="recommendateFlag", required=false, defaultValue="0") int recommendanteFlag,
			@RequestParam(value="userId", required=true) String userID
			){
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		BoardConfig conf = new BoardConfig(boardCode, 
				categoryCode, 
				typeCode, 
				adminFlag, 
				replyFlag, 
				commentFlag, 
				attchementFlag, 
				secretFlag, 
				recommendanteFlag);
		
		if( userService.isUser(userID) ){
			conf.setRegister(userID);
			int resultCount = boardService.insertBoardConfig(conf);
			if( resultCount > 0 )
				responseData.put("result", BaseController.SUCCESS_MESSAGE);
			else
				responseData.put("result", BaseController.FAILED_MESSAGE);
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
		}		
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 게시물 리스트
	 * @param boardCode
	 * @return
	 */
	@RequestMapping(value="{boardCode}/list/")
	public ModelAndView getBoardMessageList(@PathVariable("boardCode") String boardCode){
		
		List<Message> boardMessageList = boardService.getBoardMessageList(boardCode);
		
		Map<String, Object> responseData = new HashMap<String, Object>();		
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", boardMessageList);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 게시물 조회
	 * @param boardCode
	 * @param messageCode
	 * @return
	 */
	@RequestMapping(value="{boardCode}/item/{messageCode}/")
	public ModelAndView getBoardMessage(@PathVariable("boardCode") String boardCode,
			@PathVariable("messageCode") String messageCode){
		
		Message boardMessage = boardService.getBoardMessage(Integer.parseInt(messageCode));
		//log.debug("Blob Message => " + boardMessage.getMessage().getBytesMessage().toString());
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", boardMessage);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	@RequestMapping(value="{boardCode}/item/add/")
	public ModelAndView addBoardMessage(@PathVariable("boardCode") String boardCode,
			@RequestParam(value="subject", required=true) String subject,
			@RequestParam(value="message", required=true) String message,
			@RequestParam(value="userId", required=true) String userID,
			@RequestParam(value="nickName", required=true) String nickName,
			@RequestParam(value="parentMessageCode", required=true) int parentMessageCode,
			@RequestParam(value="parentMessageLevel", required=true) int parentMessageLevel,
			@RequestParam(value="secretCode", required=true) String secretCode,
			@RequestParam(value="topFlag", required=true) int topFlag,
			@RequestParam(value="tags", required=true) String tags){
		
		// 메시지 등록
		long insertId = boardService.insertMessageContent(message.getBytes());
		
		log.debug("Message Contents Insert ID => " + Integer.valueOf(Long.valueOf(insertId).toString()));
		
		// 등록 
		
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", insertId);
		
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
