package com.xaxis.bbs.model;

public class Role {
	
	private int roleId;
	private String roleName;
	private String roleUrlPattern;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleUrlPattern() {
		return roleUrlPattern;
	}
	public void setRoleUrlPattern(String roleUrlPattern) {
		this.roleUrlPattern = roleUrlPattern;
	}
	
	public Role(int roleID, String roleName, String roleUrlPattern)
	{
		this.roleId = roleID;
		this.roleName = roleName;
		this.roleUrlPattern = roleUrlPattern;
	}
}