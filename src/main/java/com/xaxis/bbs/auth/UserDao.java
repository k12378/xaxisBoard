package com.xaxis.bbs.auth;

import java.util.List;

import com.xaxis.bbs.model.Pagenation;
import com.xaxis.bbs.model.UserInfo;

public interface UserDao {
	
	public List<UserInfo> getUserAllList();
	
	public List<UserInfo> getUserList(Pagenation pagenation);
	
	public UserInfo getUserItem(String userID);
	
	public void updateUser(UserInfo user);
	
	public void deleteUser(String userID);
}
