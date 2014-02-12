package com.xaxis.bbs.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.xaxis.bbs.model.Group;
import com.xaxis.bbs.model.User;
import com.xaxis.bbs.model.UserInfo;

public class AuthenticationUserService implements UserDetailsService{
	
	private UserService userService;
	
	protected AuthenticationUserService(){
		
	}
	
	public AuthenticationUserService(UserService userService){
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserInfo userInfo = this.userService.getUserInfo(username);
		this.userService.setUser(userInfo);
		
		
		// 권한 체크
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		// 그룹 또는 role 에 따른 권한 부여
		for(Group group: userInfo.getGroups()){
			if( group.getGroupName().equals("SUPER_ADMIN") ){
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				break;
			}
		}
		
		// 유저 조회 여부에 따른 유저 권한 부여 및 조회 결과가 없을 시 Exception 처리
		if( userInfo != null ){
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}else{
			throw new UsernameNotFoundException("Not found user : "+ username);
		}				
		
		User user = new User(userInfo);
		user.setAuthorities(authorities);
		return user;
	}
}