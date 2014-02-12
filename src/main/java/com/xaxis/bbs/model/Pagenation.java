package com.xaxis.bbs.model;


public class Pagenation {
		
	private int totalRecord;
	private int pageSize;
	private final int blockPerPageSize = 10;
	
	private double currentPageNumber;
	
	private double currentBlockNumber;
	private double lastBlockNumber;
	
	private double startPageNumber;
	private double startRecordNumber;
	private double lastPageNumber;
	
	/**
	 * 
	 * @param totalRecord
	 * @param pageSize
	 * @param currentPageNumber
	 */
	public Pagenation(int totalRecord, int pageSize, int currentPageNumber){
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.currentPageNumber = currentPageNumber;		
		this.initialize();
	}
	
	public void initialize(){
		
		this.lastPageNumber = (this.totalRecord % this.pageSize == 0)? Math.ceil(this.totalRecord / this.pageSize) : Math.ceil(this.totalRecord / this.pageSize) + 1;
		
		this.currentPageNumber = (this.currentPageNumber > this.lastPageNumber) ? this.lastPageNumber : this.currentPageNumber;
		
		this.lastBlockNumber = (this.lastPageNumber <= this.blockPerPageSize)? 1 : Math.ceil(this.lastPageNumber / this.blockPerPageSize);
		this.currentBlockNumber = (this.currentPageNumber <= this.blockPerPageSize )? 1 : Math.ceil(this.currentPageNumber / this.blockPerPageSize);
		
		if( this.currentBlockNumber > this.lastBlockNumber )
			this.currentBlockNumber = this.lastBlockNumber;
		
		this.startRecordNumber = (this.currentPageNumber > this.lastPageNumber )? 
				( this.pageSize * (this.lastPageNumber - 1) ) + 1 : ( this.pageSize * (this.currentPageNumber - 1) ) + 1;
		this.startPageNumber = (this.currentBlockNumber * this.blockPerPageSize ) - ( this.blockPerPageSize - 1 );
		
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBlockPerPageSize() {
		return blockPerPageSize;
	}

	public double getCurrentPageNumber() {
		return currentPageNumber;
	}

	public double getCurrentBlockNumber() {
		return currentBlockNumber;
	}

	public double getLastBlockNumber() {
		return lastBlockNumber;
	}

	public double getstartRecordNumber() {
		return startRecordNumber;
	}

	public double getLastPageNumber() {
		return lastPageNumber;
	}

	public double getStartPageNumber() {
		return startPageNumber;
	}

	public void setStartPageNumber(double startPageNumber) {
		this.startPageNumber = startPageNumber;
	}
	
	
}