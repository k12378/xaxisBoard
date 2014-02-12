package com.xaxis.bbs.model;

public class Message {
	
	private int messageId;					// 글번호
	private String subject;					// 제목
	
	private int contentsIdx;
	private MessageContent message;			// 글 내용

	private String secretCode;				// 글 비밀번호
	
	private int recommendanteCount;			// 추천 수
	private int viewCount;					// 뷰 수
	
	private String tags;					// 태그 ',' 로 구분
	
	private int topFlag;					// 탑 설정 여부
	
	private int parentMessageCode;			// 0이 아닐시 해당 글 번호의 답글
	private int messageLevel;				// 들여쓰기 번호
	private int displayOrder;				// 보여지는 순서
	
	private String nickName;				// 별칭
	
	private String registDate;				// 등록일
	private String register;				// 등록자
	
	private String updateDate;				// 수정일
	private String updater;					// 수정자
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
		
	public int getContentsIdx() {
		return contentsIdx;
	}
	public void setContentsIdx(int contentsIdx) {
		this.contentsIdx = contentsIdx;
	}
	public MessageContent getMessage() {
		return message;
	}
	public void setMessage(MessageContent message) {
		this.message = message;
	}	
	public String getSecretCode() {
		return secretCode;
	}
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	public int getRecommendanteCount() {
		return recommendanteCount;
	}
	public void setRecommendanteCount(int recommendanteCount) {
		this.recommendanteCount = recommendanteCount;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getTopFlag() {
		return topFlag;
	}
	public void setTopFlag(int topFlag) {
		this.topFlag = topFlag;
	}
	public int getParentMessageCode() {
		return parentMessageCode;
	}
	public void setParentMessageCode(int parentMessageCode) {
		this.parentMessageCode = parentMessageCode;
	}
	public int getMessageLevel() {
		return messageLevel;
	}
	public void setMessageLevel(int messageLevel) {
		this.messageLevel = messageLevel;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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