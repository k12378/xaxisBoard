package com.xaxis.bbs.common.util.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Test;



public class TemplateTests {
	
	private Logger log = Logger.getLogger(this.getClass());
/*	
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
				log.debug("���� ����");
			}else{
				log.debug("���� ����");
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
*/
	@Test
	public void dbChaeck(){
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;

		try{
			String url = "jdbc:mysql://192.168.192.191:3306/board?useUnicode=true&characterEncoding=utf-8";
			String userid = "root";
			String password = "roqkf!@#";
			conn = DriverManager.getConnection(url, userid, password);
			
			String query = "SELECT contentsIdx as contentsID, ifnull( CONVERT(messageContents USING utf8) , '' ) as messageContent FROM messageContents WHERE contentsIdx=2";
			st = conn.createStatement();			
			rs = st.executeQuery(query);
			
			while( rs.next() ){
				log.debug( rs.getInt("contentsID") );
				log.debug( rs.getString("messageContent") );
			}
			
		}catch( Exception e ){
			
		}finally{
			if( rs != null ){ try{ rs.close(); }catch(Exception e){e.printStackTrace();}};
			if( st != null ){ try{ st.close(); }catch(Exception e){e.printStackTrace();}};
			if( conn != null ){ try{ conn.close(); }catch(Exception e){e.printStackTrace();}};
		}
		
	}
}
