package com.xaxis.bbs.common.util.test;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.security.crypto.codec.Base64;

import com.xaxis.bbs.common.util.Base64Coder;



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
/*	
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
			
			String query = "SELECT contentsIdx as contentsID, messageContents as messageContent FROM messageContents WHERE contentsIdx=5";
			st = conn.createStatement();			
			rs = st.executeQuery(query);
			
			InputStream messageByteContents = null;
			int contentsId = 0;
			byte[] cutByte = new byte[256];
			while( rs.next() ){
				contentsId = rs.getInt("contentsID");
				messageByteContents = rs.getBlob("messageContent").getBinaryStream();
			}
			
			StringBuffer out = new StringBuffer();
			for(int i; (i=messageByteContents.read(cutByte)) != -1; ){
				out.append(new String(cutByte, 0, i));
			}
			
			log.debug("contents => "+out.toString());
			
			
			
			
		}catch( Exception e ){
			e.printStackTrace();
		}finally{
			if( rs != null ){ try{ rs.close(); }catch(Exception e){e.printStackTrace();}};
			if( st != null ){ try{ st.close(); }catch(Exception e){e.printStackTrace();}};
			if( conn != null ){ try{ conn.close(); }catch(Exception e){e.printStackTrace();}};
		}
		
	}
*/	
	
	@Test
	public void base64DecodeTest() throws UnsupportedEncodingException{
		String encodeKey = "cbn2bjJ2VTEq2rl3";
		
		//byte[] base64DecodeByte = Base64Coder.decode(base64EncodeKey);
		byte[] encodeByteKey = encodeKey.getBytes("KSC5601");
		log.debug( Base64.isBase64(encodeByteKey) );
		if( Base64.isBase64(encodeByteKey) ){
			byte[] decodeByte =  Base64.decode(encodeByteKey);
			log.debug("decode Text => "+ new String(decodeByte));
		}
		
		String decodeKey = "2792374";
		
		String encodeByteKey1 = Base64Coder.encodeString(decodeKey);
		
		log.debug(encodeByteKey1);
		
		
		
		
		
		
		//log.debug("decode Text =>"+ new String(base64DecodeByte, 0, base64DecodeByte.length));
		//log.debug("decode Text =>"+  new String(base64DecodeByte));
	}
}
