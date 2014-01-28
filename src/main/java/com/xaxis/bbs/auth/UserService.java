package com.xaxis.bbs.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xaxis.bbs.model.Group;
import com.xaxis.bbs.model.Role;
import com.xaxis.bbs.model.UserInfo;

@Service
public class UserService {
	
	public UserInfo getUserInfo(String userID){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		
		
		
		UserInfo user = new UserInfo();
		user.setSid(1);
		user.setUserID(userID);
		user.setUserName("슈퍼관리자");
		user.setUserPassword( encoder.encode("zjsqjwjstm") );
		
		List<Group> groups = new ArrayList<Group>();
		groups.add(new Group(1, "GroupName1"));
		user.setGroups(groups);
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role(1, userID, "/Board"));
		user.setRoles(roles);
	
		return user;
	}
	
	public boolean isUser(String userID){
		
		return (userID.equals("rmkdev"))? true: false;
	}
	
	public boolean isEqualsPassword(String password){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		
		return encoder.encode("zjsqjwjstm").equals(encoder.encode(password));
	}

	public List<UserInfo> getUserAllList() {
		// TODO Auto-generated method stub
		return null;
	}
}