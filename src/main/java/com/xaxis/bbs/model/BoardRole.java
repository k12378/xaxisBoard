package com.xaxis.bbs.model;

public class BoardRole {
	
	private String boardID;
	private int groupCode;
	private int roleCode;
	private String groupName;
	private String roleName;	
	
	public String getBoardID() {
		return boardID;
	}
	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public int getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}	
}