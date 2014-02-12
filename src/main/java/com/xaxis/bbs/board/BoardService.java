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
	
	public long insertMessageContent(@Param("bytesMessage") byte[] bytesMessage){
		boardDao = sqlSessionTemplate.getMapper(BoardDao.class);
		return boardDao.insertMessageContent(bytesMessage);
	}
	
}
