package com.xaxis.bbs.model;

public class BoardConfig {
	
	private String boardCode;
	private int categoryCode;
	private String categoryName;
	private String boardTypeCode;
	
	// 관리자 작성 전용 게시판 여부
	private int adminFlag;
	// 답글 사용 여부
	private int replyFlag;
	// 댓글 사용 여부
	private int commentFlag;
	// 첨부파일 사용 여부
	private int attchementFlag;
	// 비밀글 여부
	private int secretFlag;
	// 추천 시스템 사용 여부
	private int recommendanteFlag;
		
	private String registDate;
	private String register;
	
	private String updateDate;
	private String updater;
	
	
	/**
	 * 
	 * @param boardCode
	 * @param categoryCode
	 * @param boardTypeCode
	 * @param adminFlag
	 * @param replyFlag
	 * @param commentFlag
	 * @param attchementFlag
	 * @param secretFlag
	 * @param recommendanteFlag
	 */
	public BoardConfig(String boardCode,
			int categoryCode,
			String boardTypeCode,
			int adminFlag,
			int replyFlag,
			int commentFlag,
			int attchementFlag,
			int secretFlag,
			int recommendanteFlag){
		
		this.boardCode = boardCode;
		this.categoryCode = categoryCode;
		this.boardTypeCode = boardTypeCode;
		this.adminFlag = adminFlag;
		this.replyFlag = replyFlag;
		this.commentFlag = commentFlag;
		this.attchementFlag = attchementFlag;
		this.secretFlag = secretFlag;
		this.recommendanteFlag = recommendanteFlag;
	}
	
	
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
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
	public String getBoardTypeCode() {
		return boardTypeCode;
	}
	public void setBoardTypeCode(String boardTypeCode) {
		this.boardTypeCode = boardTypeCode;
	}
	public int getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
	}
	public int getReplyFlag() {
		return replyFlag;
	}
	public void setReplyFlag(int replyFlag) {
		this.replyFlag = replyFlag;
	}
	public int getCommentFlag() {
		return commentFlag;
	}
	public void setCommentFlag(int commentFlag) {
		this.commentFlag = commentFlag;
	}
	public int getAttchementFlag() {
		return attchementFlag;
	}
	public void setAttchementFlag(int attchementFlag) {
		this.attchementFlag = attchementFlag;
	}
	public int getSecretFlag() {
		return secretFlag;
	}
	public void setSecretFlag(int secretFlag) {
		this.secretFlag = secretFlag;
	}
	public int getRecommendanteFlag() {
		return recommendanteFlag;
	}
	public void setRecommendanteFlag(int recommendanteFlag) {
		this.recommendanteFlag = recommendanteFlag;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}	
}