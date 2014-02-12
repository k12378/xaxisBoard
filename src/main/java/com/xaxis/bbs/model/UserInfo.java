package com.xaxis.bbs.model;

import java.util.List;

public class UserInfo {
	private String userID;
	private String userPassword;
	private String userName;
	private String teamName;
	private List<Group> groups;
	
	public UserInfo(){
		
	}
	
	public UserInfo(String userID, String userPassword, String userName, List<Group> groups)
	{
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.groups = groups;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}