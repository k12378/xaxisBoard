package com.xaxis.bbs.helloworld;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xaxis.bbs.common.util.FileUtil;

@Controller
@RequestMapping("/helloworld/")
public class HelloWorldController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private FileUtil fileUtil = new FileUtil();
	
	@RequestMapping("hello/")
	public String helloWorld(){
		log.debug("HelloWorldController");
		return "helloworld";
	}
	
	@RequestMapping("uploadForm/")
	public String fileForm()
	{
		return "fileForm";
	}
	
	@RequestMapping(value="upload/", method=RequestMethod.POST)
	public ModelAndView fileUpload(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value="file", required=true) List<MultipartFile> fileList)
	{
		
		log.debug("File count => " + fileList.size());
		
		for( MultipartFile file: fileList )
		{
			if( !file.isEmpty() ){
							
				Map<String, Object> templateObj = this.fileUtil.uploadFile(file, "E:\\SBS\\TEST");
				
				log.debug("===== > Uploaded File Infomation  < =====");
				log.debug("Success Flag => " + templateObj.get("Flag"));
				log.debug("File Name => " + templateObj.get("FileName"));
				log.debug("File Path => " + templateObj.get("FilePath"));
				log.debug("File MimeType => " + templateObj.get("FileMimeType"));
				log.debug("File Size => " + templateObj.get("FileSize"));
				
				// ���� ���� ����
			}
		}		
		
		return new ModelAndView("fileForm");
	}
	
	@RequestMapping("download/")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		String absoluteFilePath="E:\\SBS\\TEST\\1390208899553_02_panel_koreanclick_sitedemo_201210.txt";
		String mimeType="text/plain";
		long fileSize=1077844;
		
		this.fileUtil.download(request, response, absoluteFilePath, mimeType, fileSize);
	}
	
		
	/**
	 * type : function
	 * name : index
	 * description : BoardID �Ķ������ ���� ���η� ���� ���� ���� Front ����  
	 * @param boardID - �Խ��� �ڵ�
	 * @return ModelAndView
	*/
	@RequestMapping(value="/index/", method=RequestMethod.GET)
	public String index(@RequestParam(value="BoardID", required=false) String boardID){		
		log.debug("Request Parameter BoardID => " + boardID);
		/*
		if( boardID!=null && !boardID.isEmpty() ){
			
//				boardID ���� ���� �Ǵ�
//				��ų� ���� ���� ���� ��� ���ڷ� �Ǵ�.. ���� �α��� �������� �̵�.
						
			//return new ModelAndView("redirect:/board/list.do?BoardID="+ boardID);
			return new ModelAndView("index");
		}else{
			return new ModelAndView("redirect:/admin/index.do");
		}
		*/
		return "index";
	}

}
