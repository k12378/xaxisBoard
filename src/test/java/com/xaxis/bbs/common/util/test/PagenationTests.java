package com.xaxis.bbs.common.util.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.xaxis.bbs.model.Pagenation;

public class PagenationTests {
	
	@Test
	public void tests(){
		Pagenation pageObj = new Pagenation(324831, 40, 56);
		this.printPagenationObject(pageObj);
	}
	
	public void printPagenationObject(Pagenation pageObj){
		Logger log = Logger.getLogger(this.getClass());
		
		log.debug("totalRecord => "+ pageObj.getTotalRecord());
		log.debug("pageSize => "+ pageObj.getPageSize());
		log.debug("blockPerPageSize => "+ pageObj.getBlockPerPageSize());
		log.debug("currentPageNumber => "+ pageObj.getCurrentPageNumber());		
		log.debug("========> <===========");		
		log.debug("currentBlockNumber => "+ pageObj.getCurrentBlockNumber());
		log.debug("lastBlockNumber => "+ pageObj.getLastBlockNumber());
		log.debug("startRecordNumber => " + pageObj.getstartRecordNumber());
		log.debug("startPageNumber => "+ pageObj.getStartPageNumber());
		log.debug("lastPageNumber => "+ pageObj.getLastPageNumber());
	}
}
