package com.xaxis.bbs.model;

import java.util.List;

public class UserInfo {
	private int sid;
	private String userID;
	private String userPassword;
	private String userName;
	private List<Group> groups;
	private List<Role> roles;
	
	public UserInfo(){
		
	}
	
	public UserInfo(int sid, String userID, String userPassword, String userName, List<Group> groups, List<Role> roles)
	{
		this.sid = sid;
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.groups = groups;
		this.roles = roles;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}