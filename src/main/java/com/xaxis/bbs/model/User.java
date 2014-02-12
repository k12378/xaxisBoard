package com.xaxis.bbs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User extends UserInfo implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	public User(UserInfo user){
		if( user != null ){
			this.setUserID(user.getUserID());
			this.setUserName(user.getUserName());
			this.setUserPassword(user.getUserPassword());
			this.setTeamName(user.getTeamName());
			this.setGroups(user.getGroups());
		}
	}
	
	public void setAuthorities(List<GrantedAuthority> authorities){
		this.authorities.addAll(authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getUserID();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}	
}