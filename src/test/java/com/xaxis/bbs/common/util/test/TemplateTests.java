package com.xaxis.bbs.common.util.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.xaxis.bbs.common.util.StringUtil;

public class TemplateTests {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void urlTests(){
		
		String url = "http://localhost:8080/auth/login.do";
		URL currentUrl;
		try {
			currentUrl = new URL(url);
			String host = currentUrl.getHost();
			String path = currentUrl.getPath();
			String param = currentUrl.getQuery();
			
			log.debug( path );
			log.debug( path.indexOf("/auth/") );
			
			if( path.indexOf("/auth/") == -1 ){
				log.debug("권한 없음");
			}else{
				log.debug("권한 있음");
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void stringTests(){
		StringUtil sUtil = new StringUtil();
		
		//log.debug( "Result => " + sUtil.numberToDivisionComma(100000000) );
	}
}
