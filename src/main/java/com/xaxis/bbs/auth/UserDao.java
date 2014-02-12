package com.xaxis.bbs.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xaxis.bbs.model.Pagenation;
import com.xaxis.bbs.model.UserInfo;

public interface UserDao {
	
	public List<UserInfo> getUserAllList();
	
	public List<UserInfo> getUserList(Pagenation pagenation);
	
	public UserInfo getUserItem(String userID);
	
	public Integer checkUserInfo(@Param("userID") String userID, @Param("userPW") String userPW);
	
}
