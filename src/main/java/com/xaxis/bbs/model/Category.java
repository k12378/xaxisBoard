package com.xaxis.bbs.model;

public class Category {
	private int categoryCode;
	private String categoryName;
	private int parentCode;
	private int depth;
	private int displayOrder;
	
	public Category(){
		
	}
	
	public Category(int categoryCode, String categoryName ){
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getParentCode() {
		return parentCode;
	}

	public void setParentCode(int parentCode) {
		this.parentCode = parentCode;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	
}