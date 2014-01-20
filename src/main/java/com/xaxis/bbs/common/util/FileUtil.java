package com.xaxis.bbs.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	private static Boolean appDebugMode = true;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	public Map<String, Object> uploadFile(MultipartFile uploadFileObject, String absoluteSavePath )
	{
		
		Map<String, Object> saveFileResultObj = new HashMap<String, Object>();
		
		File savePath = new File(absoluteSavePath);
		
		File saveFile = null;
		
		
		// 실제 저장 경로의 폴더가 생성되어 있는지 검사
		if( !savePath.exists() )
		{
			// 폴더가 없을 경우 폴더 생성.
			savePath.mkdirs();
		}
		
		try{
			// 파라미터로 전달 받은 파일이 비어 있는지 확인
			if( !uploadFileObject.isEmpty() )
			{
				// Debug 모드가 설정 도어 있을 경우 업로드 파일 정보 출력
				if( appDebugMode )
				{					
					log.debug("===== > UploadFile Infomation < =====");
					log.debug("File Name : "+ uploadFileObject.getOriginalFilename());
					log.debug("File MimeType : "+ uploadFileObject.getContentType());
					log.debug("File Size : "+ uploadFileObject.getSize());
					log.debug("=====================================");
				}
				
				// 저장할 유니크할 파일명 생성
				String templateFileName = System.currentTimeMillis() + "_" + uploadFileObject.getOriginalFilename();
				saveFile = new File( absoluteSavePath + System.getProperty("file.separator") + templateFileName );
				
				// 파일 정보 저장
				saveFileResultObj.put("FileName", templateFileName);
				saveFileResultObj.put("FilePath", absoluteSavePath);
				saveFileResultObj.put("FileMimeType", uploadFileObject.getContentType());
				saveFileResultObj.put("FileSize", uploadFileObject.getSize());
				
				// 파일 저장
				uploadFileObject.transferTo(saveFile);
				
				// 에러가 없을 경우 해당 파일 저장의 성공 여부를 Obj에 기록 하여 전달
				saveFileResultObj.put("Flag", true);
				
			}
			
		}catch(IOException ie){
			ie.printStackTrace();
			saveFileResultObj.put("Flag", false);
		}
		return saveFileResultObj;
	}
	
	public void download(HttpServletRequest request, HttpServletResponse response, String absoluteFilePath, String mimeType, long fileSize) throws IOException
	{
		File downloadFile = new File(absoluteFilePath);
		
		String mime = mimeType;
		
		// 버퍼 사이즈
		final int BUFFER_SIZE = 8192; // 8kb
		// 문자 인코딩
		final String CHARSET = "euc-kr";
		
		
		log.debug("Exits => "+ downloadFile.exists());
		log.debug("Length => "+ downloadFile.length());
		log.debug("is Dir => "+ downloadFile.isDirectory());
		
		
		// 실제 파일 존재 여부 확인.
		if( !downloadFile.exists() || downloadFile == null || downloadFile.length() <= 0 || downloadFile.isDirectory() )
		{
			throw new IOException("파일 객체를 찾을 수 없습니다.");
		}		
		
		if( mimeType == null || mimeType.length() == 0 )
			mime="application/octet-stream";
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		response.setContentType(mime + "; charset="+ CHARSET);
		
		// 아래 부분에서 euc-kr 을 utf-8 로 바꾸거나 URLEncoding을 안하거나 등의 테스트를
	    // 해서 한글이 정상적으로 다운로드 되는 것으로 지정한다.
	    String userAgent = request.getHeader("User-Agent");
	 
	    // attachment; 가 붙으면 IE의 경우 무조건 다운로드창이 뜬다. 상황에 따라 써야한다.
	    if (userAgent != null && userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 이하
	      response.setHeader("Content-Disposition", "filename=" + URLEncoder.encode(downloadFile.getName(), "UTF-8") + ";");
	    } else if (userAgent != null && userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
	      response.setHeader("Content-Disposition", "attachment; filename="
	          + java.net.URLEncoder.encode(downloadFile.getName(), "UTF-8") + ";");
	    } else { // 모질라나 오페라
	      response.setHeader("Content-Disposition", "attachment; filename="
	          + new String(downloadFile.getName().getBytes(CHARSET), "latin1") + ";");
	    }
	 
	    // 파일 사이즈가 정확하지 않을때는 아예 지정하지 않는다.
	    if (fileSize > 0) {
	      response.setHeader("Content-Length", "" + fileSize);
	    }
	    
	    InputStream is = new FileInputStream(downloadFile);
	    BufferedInputStream fin = null;
	    BufferedOutputStream outs = null;
	    
	    try {
	        fin = new BufferedInputStream(is);
	        outs = new BufferedOutputStream(response.getOutputStream());
	        int read = 0;
	   
	        while ((read = fin.read(buffer)) != -1) {
	          outs.write(buffer, 0, read);
	        }
	      } catch (IOException ex) {
	          ex.printStackTrace();
	      } finally {
	        try {
	          outs.close();
	        } catch (Exception ex1) {
	        }
	   
	        try {
	          fin.close();
	        } catch (Exception ex2) {
	   
	        }
	      } // end of try/catch
		
		
	}
}
