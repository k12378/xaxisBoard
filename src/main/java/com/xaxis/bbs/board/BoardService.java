package com.xaxis.bbs.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xaxis.bbs.model.BoardConfig;
import com.xaxis.bbs.model.Message;
import com.xaxis.bbs.model.MessageContent;

@Service
@Transactional
public class BoardService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	private BoardDao boardDao;
	
	/**
	 * 
	 * @param boardCode
	 * @return
	 */
	public BoardConfig getBoardConfig(String boardCode){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.getBoardConfig(boardCode);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<BoardConfig> getBoardConfigList(){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.getBoardConfigList();
	}
	
	/**
	 * 
	 * @param boardConfig
	 * @return
	 */
	public int insertBoardConfig(BoardConfig boardConfig){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.insertBoardConfig(boardConfig);
	}
	
	/**
	 * 
	 * @param boardConfig
	 */
	public void updateBoard(BoardConfig boardConfig){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.updateBoardConfig(boardConfig);
	}
	
	public void deleteBoard(String boardCode){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.deleteBoardConfig(boardCode);
	}
	
	
	/**
	 * 
	 * @param boardCode
	 * @return
	 */
	public List<Message> getBoardMessageList(String boardCode){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.getBoardMessageList(boardCode);
	}
	
	/**
	 * 
	 * @param messageCode
	 * @return
	 */
	public Message getBoardMessage(@Param("messageCode") int messageCode){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.getBoardMessage(messageCode);
	}
	
	public int insertMessage(Message message){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.insertMessage(message);
		return message.getMessageId();
	}
	
	public void updateMessage(Message message){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.updateMessage(message);
	}
	
	public void deleteMessageId(int messageId){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.deleteMessage(messageId);
	}
	
	public int isEqualsSecretCode(int messageCode, String secretCode){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.isEqualsSecretCode(messageCode, secretCode);
	}
	
	public boolean isMessageEqualsWriter(int messageCode, String userId){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);		
		return (boardDao.isMessageEqualsWriter(messageCode, userId) > 0 )? true : false;
	}
	
	public int insertMessageContent(MessageContent messageContent){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.insertMessageContent(messageContent);
		return messageContent.getContentsID();
	}
	
	public void updateMessageContent(MessageContent messageContent){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardDao.updateMessageContent(messageContent);
	}
	
}
