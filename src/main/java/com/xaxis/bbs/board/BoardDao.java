package com.xaxis.bbs.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xaxis.bbs.model.BoardConfig;
import com.xaxis.bbs.model.Message;
import com.xaxis.bbs.model.MessageContent;

public interface BoardDao {
	
	/**
	 * 
	 * @param boardCode
	 * @return
	 */
	public BoardConfig getBoardConfig(@Param("boardCode") String boardCode);
	
	/**
	 * 
	 * @return
	 */
	public List<BoardConfig> getBoardConfigList();
	
	/**
	 * 
	 * @param boardConfig
	 */
	public int insertBoardConfig(BoardConfig boardConfig);
	
	/**
	 * 
	 * @param boardConfig
	 */
	public void updateBoardConfig(BoardConfig boardConfig);
	
	/**
	 * 
	 * @param boardCode
	 */
	public void deleteBoardConfig(@Param("boardCode") String boardCode);
	
	/**
	 * 
	 * @param boardCode
	 * @param messageCode
	 * @return
	 */
	public Message getBoardMessage(@Param("messageCode") int messageCode);
	
	
	/**
	 * 
	 * @param boardCode
	 * @return
	 */
	public List<Message> getBoardMessageList(@Param("boardCode") String boardCode);
	
	
	
	
	public int insertMessage(Message message);
	
	public void updateMessage(Message message);
	
	public void deleteMessage(@Param("messageId") int messageId);
	
	public int isEqualsSecretCode(@Param("messageCode") int messageCode, @Param("secretCode") String secretCode);
	
	public int isMessageEqualsWriter(@Param("messageCode") int messageCode, @Param("userId") String userId);
	
	public int insertMessageContent(MessageContent messageContent);
	
	public void updateMessageContent(MessageContent messageContent);
	
	
}