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
		
		
		// ���� ���� ����� ������ �����Ǿ� �ִ��� �˻�
		if( !savePath.exists() )
		{
			// ������ ���� ��� ���� ����.
			savePath.mkdirs();
		}
		
		try{
			// �Ķ���ͷ� ���� ���� ������ ��� �ִ��� Ȯ��
			if( !uploadFileObject.isEmpty() )
			{
				// Debug ��尡 ���� ���� ���� ��� ���ε� ���� ���� ���
				if( appDebugMode )
				{					
					log.debug("===== > UploadFile Infomation < =====");
					log.debug("File Name : "+ uploadFileObject.getOriginalFilename());
					log.debug("File MimeType : "+ uploadFileObject.getContentType());
					log.debug("File Size : "+ uploadFileObject.getSize());
					log.debug("=====================================");
				}
				
				// ������ ����ũ�� ���ϸ� ����
				String templateFileName = System.currentTimeMillis() + "_" + uploadFileObject.getOriginalFilename();
				saveFile = new File( absoluteSavePath + System.getProperty("file.separator") + templateFileName );
				
				// ���� ���� ����
				saveFileResultObj.put("FileName", templateFileName);
				saveFileResultObj.put("FilePath", absoluteSavePath);
				saveFileResultObj.put("FileMimeType", uploadFileObject.getContentType());
				saveFileResultObj.put("FileSize", uploadFileObject.getSize());
				
				// ���� ����
				uploadFileObject.transferTo(saveFile);
				
				// ������ ���� ��� �ش� ���� ������ ���� ���θ� Obj�� ��� �Ͽ� ����
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
		
		// ���� ������
		final int BUFFER_SIZE = 8192; // 8kb
		// ���� ���ڵ�
		final String CHARSET = "euc-kr";
		
		
		log.debug("Exits => "+ downloadFile.exists());
		log.debug("Length => "+ downloadFile.length());
		log.debug("is Dir => "+ downloadFile.isDirectory());
		
		
		// ���� ���� ���� ���� Ȯ��.
		if( !downloadFile.exists() || downloadFile == null || downloadFile.length() <= 0 || downloadFile.isDirectory() )
		{
			throw new IOException("���� ��ü�� ã�� �� �����ϴ�.");
		}		
		
		if( mimeType == null || mimeType.length() == 0 )
			mime="application/octet-stream";
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		response.setContentType(mime + "; charset="+ CHARSET);
		
		// �Ʒ� �κп��� euc-kr �� utf-8 �� �ٲٰų� URLEncoding�� ���ϰų� ���� �׽�Ʈ��
	    // �ؼ� �ѱ��� ���������� �ٿ�ε� �Ǵ� ������ �����Ѵ�.
	    String userAgent = request.getHeader("User-Agent");
	 
	    // attachment; �� ������ IE�� ��� ������ �ٿ�ε�â�� ���. ��Ȳ�� ���� ����Ѵ�.
	    if (userAgent != null && userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 ����
	      response.setHeader("Content-Disposition", "filename=" + URLEncoder.encode(downloadFile.getName(), "UTF-8") + ";");
	    } else if (userAgent != null && userAgent.indexOf("MSIE") > -1) { // MS IE (������ 6.x �̻� ����)
	      response.setHeader("Content-Disposition", "attachment; filename="
	          + java.net.URLEncoder.encode(downloadFile.getName(), "UTF-8") + ";");
	    } else { // ������ �����
	      response.setHeader("Content-Disposition", "attachment; filename="
	          + new String(downloadFile.getName().getBytes(CHARSET), "latin1") + ";");
	    }
	 
	    // ���� ����� ��Ȯ���� �������� �ƿ� �������� �ʴ´�.
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
