package com.xaxis.bbs.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xaxis.bbs.common.util.Base64Coder;
import com.xaxis.bbs.model.UserInfo;

@Service
@Transactional
public class UserService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	private UserDao userDao;
	
	private UserInfo user = null;
		
	/**
	 * 유저 정보를 가져옴
	 * @param userID
	 * @return
	 */
	public UserInfo getUserInfo(String userID){
		userDao = sqlSessionTemplate.getMapper(UserDao.class);
		return userDao.getUserItem(userID);
	}
	
	/**
	 * 유저 인지 확인
	 * @param userID
	 * @return
	 */
	public boolean isUser(String userID){
		userDao = sqlSessionTemplate.getMapper(UserDao.class);
		UserInfo userInfo = userDao.getUserItem(userID);
		return (userInfo != null)? true: false;
	}
	
	/**
	 * 패스워드가 같은지 확인
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public boolean isEqualsPassword(String userID, String userPw){
		log.debug("Param password => " + userPw);
		userDao = sqlSessionTemplate.getMapper(UserDao.class);
		Integer cnt = userDao.checkUserInfo(userID, userPw);
		
		return (cnt > 0)? true:false;
	}
	
	/**
	 * 모든 유저 리스트를 가져온다
	 * @return
	 */
	public List<UserInfo> getUserAllList() {
		userDao = sqlSessionTemplate.getMapper(UserDao.class);
		return userDao.getUserAllList();
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
}