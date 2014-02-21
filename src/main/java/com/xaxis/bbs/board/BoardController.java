package com.xaxis.bbs.board;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xaxis.bbs.BaseController;
import com.xaxis.bbs.auth.UserService;
import com.xaxis.bbs.group.GroupService;
import com.xaxis.bbs.model.BoardConfig;
import com.xaxis.bbs.model.Message;
import com.xaxis.bbs.model.MessageContent;

@Controller
@RequestMapping("/board/")
public class BoardController implements BaseController{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
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
		
		
		responseData.put("success", BaseController.SUCCESS_MESSAGE);
		responseData.put("data", boardConfig);
		
		return new ModelAndView("jsonView", responseData);
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
		
		
		responseData.put("success", BaseController.SUCCESS_MESSAGE);
		responseData.put("data", boardConfigList);
		
		return new ModelAndView("jsonView", responseData);
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
		
		responseData.put("success", BaseController.SUCCESS_MESSAGE);
		
		return new ModelAndView("jsonView", responseData);
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
			responseData.put("success", BaseController.SUCCESS_MESSAGE);
		}else{
			responseData.put("success", BaseController.FAILED_MESSAGE);
		}		
		return new ModelAndView("jsonView", responseData);
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
				responseData.put("success", BaseController.SUCCESS_MESSAGE);
			else
				responseData.put("success", BaseController.FAILED_MESSAGE);
		}else{
			responseData.put("success", BaseController.FAILED_MESSAGE);
		}		

		return new ModelAndView("jsonView", responseData);
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
		
		responseData.put("success", BaseController.SUCCESS_MESSAGE);
		responseData.put("message", "");
		responseData.put("data", boardMessageList);
		
		return new ModelAndView("jsonView", responseData);
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
		
		// null Check
		if( boardMessage != null ){
			if( boardMessage.getMessage().getBytesMessage() != null )
				boardMessage.getMessage().setMessageContents( new String( boardMessage.getMessage().getBytesMessage(), 0, boardMessage.getMessage().getBytesMessage().length) );
			else
				boardMessage.getMessage().setMessageContents("");
		}
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("success", BaseController.SUCCESS_MESSAGE);
		responseData.put("message", "");
		responseData.put("data", boardMessage);
		
		return new ModelAndView("jsonView", responseData);
	}
	
	/**
	 * 게시물 등록
	 * @param boardCode
	 * @param subject
	 * @param message
	 * @param userID
	 * @param nickName
	 * @param parentMessageCode
	 * @param parentMessageLevel
	 * @param secretCode
	 * @param topFlag
	 * @param tags
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="{boardCode}/item/add/")
	public ModelAndView addBoardMessage(@PathVariable("boardCode") String boardCode,
			@RequestParam(value="subject", required=true, defaultValue="") String subject,
			@RequestParam(value="message", required=true, defaultValue="") String message,
			@RequestParam(value="userId", required=true, defaultValue="") String userID,
			@RequestParam(value="nickName", required=true, defaultValue="ANONYMOUS") String nickName,
			@RequestParam(value="parentMessageCode", required=true, defaultValue="0") int parentMessageCode,
			@RequestParam(value="parentMessageLevel", required=true, defaultValue="0") int parentMessageLevel,
			@RequestParam(value="secretCode", required=true, defaultValue="") String secretCode,
			@RequestParam(value="topFlag", required=true, defaultValue="0") int topFlag,
			@RequestParam(value="tags", required=true, defaultValue="") String tags) throws UnsupportedEncodingException{
		
		// 메시지 등록
		MessageContent messageContentParam = new MessageContent();
		messageContentParam.setBytesMessage(message.getBytes("UTF-8"));
		int insertMessageContentId = boardService.insertMessageContent( messageContentParam );		
		log.debug("Message Contents Insert ID => " + insertMessageContentId);
		
		// 등록 
		// displayOrder / messageLevel  값 조회 및 조정		
		Message messageParam = new Message();
		messageParam.setBoardCode(boardCode);
		messageParam.setSubject(subject);
		messageParam.setContentsIdx(insertMessageContentId);
		messageParam.setRegister(userID);
		messageParam.setNickName(nickName);
		messageParam.setParentMessageCode(parentMessageCode);
		messageParam.setMessageLevel(parentMessageLevel);
		messageParam.setSecretCode(secretCode);
		messageParam.setTopFlag(topFlag);
		messageParam.setTags(tags);
		messageParam.setDisplayOrder(0);
		
		int insertMessageId = boardService.insertMessage(messageParam);
		
		log.debug("Message Insert ID => " + insertMessageId);
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", insertMessageId);
		
		return new ModelAndView("jsonView", responseData);
	}
	
	/**
	 * 게시물 수정
	 * @param boardCode
	 * @param messageCode
	 * @param subject
	 * @param message
	 * @param userID
	 * @param nickName
	 * @param parentMessageCode
	 * @param parentMessageLevel
	 * @param secretCode
	 * @param topFlag
	 * @param tags
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value="{boardCode}/item/{messageCode}/update/")
	public ModelAndView updateBoardMessage(@PathVariable("boardCode") String boardCode,
			@PathVariable("messageCode") int messageCode,
			@RequestParam(value="subject", required=true, defaultValue="") String subject,
			@RequestParam(value="messageContentId", required=true) int messageContentId,
			@RequestParam(value="message", required=true, defaultValue="") String message,
			@RequestParam(value="userId", required=true, defaultValue="") String userId,
			@RequestParam(value="nickName", required=true, defaultValue="ANONYMOUS") String nickName,
			@RequestParam(value="parentMessageCode", required=true, defaultValue="0") int parentMessageCode,
			@RequestParam(value="parentMessageLevel", required=true, defaultValue="0") int parentMessageLevel,
			@RequestParam(value="secretCode", required=true, defaultValue="") String secretCode,
			@RequestParam(value="topFlag", required=true, defaultValue="0") int topFlag,
			@RequestParam(value="tags", required=true, defaultValue="") String tags) throws UnsupportedEncodingException{
		
		boolean updateFlag = false;
		boolean userFlag = false;
		// 글쓴이 인지 확인
		if( !userId.equals("") && userService.isUser(userId) ){
			userFlag = boardService.isMessageEqualsWriter(messageCode, userId);
		}
			
		
		// 익명 비밀번호 확인 및 수정 플레그 업데이트
		if( !userFlag && !nickName.equals("") ){
			int isWriter = boardService.isEqualsSecretCode(messageCode, secretCode);
			if( isWriter > 0 )
				updateFlag = true;
		}else{
			updateFlag = true;
		}
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		if( updateFlag ){
			
			// 메시지 컨텐츠 수정
			MessageContent messageContentParam = new MessageContent();
			messageContentParam.setContentsID(messageContentId);
			messageContentParam.setBytesMessage(message.getBytes("UTF-8"));
			
			boardService.updateMessageContent(messageContentParam);			
			
			// 메지시 수정
			Message messageParam = new Message();
			messageParam.setMessageId(messageCode);
			messageParam.setBoardCode(boardCode);
			messageParam.setSubject(subject);
			messageParam.setNickName(nickName);
			messageParam.setParentMessageCode(parentMessageCode);
			messageParam.setMessageLevel(parentMessageLevel);
			messageParam.setSecretCode(secretCode);
			messageParam.setTopFlag(topFlag);
			messageParam.setTags(tags);
			messageParam.setDisplayOrder(0);
			
			if( userFlag ){
				messageParam.setUpdater(userId);
			}else{
				messageParam.setUpdater("ANONYMOUS");
			}
			
			boardService.updateMessage(messageParam);
			
			
			responseData.put("result", BaseController.SUCCESS_MESSAGE);
			responseData.put("resultData", URLEncoder.encode("성공"));
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
			if( !userFlag )
				responseData.put("resultData", URLEncoder.encode("비밀번호를 확인 하여 주시기 바랍니다.") );
		}
		
		return new ModelAndView("jsonView", responseData);
	}
	
	@RequestMapping(value="{boardCode}/item/{messageCode}/delete/", method=RequestMethod.POST)
	public ModelAndView deleteBoardMessage(@PathVariable("boardCode") String boardCode,
			@PathVariable("messageCode") int messageCode,
			@RequestParam("userId") String userId,
			@RequestParam("secretCode") String secretCode){
		
		boolean updateFlag = false;
		boolean userFlag = false;
		boolean adminFlag = false;		
		
		// 유저 확인
		if( !userId.equals("") && userService.isUser(userId) ){
			userFlag = boardService.isMessageEqualsWriter(messageCode, userId);
			if( !userFlag ){
				// 슈퍼 관리자 여부 확인
				adminFlag = groupService.checkUserAdmin(userId, "SUPER_ADMIN");
			}
		}		
		
		// 익명 비밀번호 확인 및 수정 플레그 업데이트
		if( !userFlag && !adminFlag ){			
			int isWriter = boardService.isEqualsSecretCode(messageCode, secretCode);
			if( isWriter > 0 )
				updateFlag = true;
		}else{
			updateFlag = true;
		}
		
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		if( updateFlag ){
			boardService.deleteMessageId(messageCode);
			responseData.put("result", BaseController.SUCCESS_MESSAGE);
		}else{
			responseData.put("result", BaseController.FAILED_MESSAGE);
		}
		return new ModelAndView("jsonView", responseData);
	}
	
	@Override
	public ModelAndView getList(int currentPage, int paseSize,
			String searchField, String searchKeyword, String descField,
			String descCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
