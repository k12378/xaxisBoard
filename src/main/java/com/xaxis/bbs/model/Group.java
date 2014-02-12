package com.xaxis.bbs.model;

public class Group{
	
	private int groupID;
	private String groupName;
	private String registDate;
	private String register;
	
	public Group(){
		
	}
	
	public Group(int groupID, String groupName, String register){
		this.groupID = groupID;
		this.groupName = groupName;
		this.register = register;
	}
	
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Group(int groupID, String groupName){
		this.groupID = groupID;
		this.groupName = groupName;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}	
}