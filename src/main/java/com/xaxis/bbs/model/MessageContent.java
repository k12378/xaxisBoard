package com.xaxis.bbs.model;

public class MessageContent {
	
	private int contentsID;	
	private byte[] bytesMessage;
	private String messageContents;
/*	
	public MessageContent(int contentsID, byte[] bytesMessage){
		this.contentsID = contentsID;
		this.messageContents = bytesMessage.toString();
		this.bytesMessage = bytesMessage;
	}
	
	public MessageContent(){
		
	}
*/	
	public int getContentsID() {
		return contentsID;
	}
	
	public void setContentsID(int contentsID) {
		this.contentsID = contentsID;
	}
	
	public String getMessageContents() {		
		return messageContents;
	}
	
	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}

	public byte[] getBytesMessage() {
		return bytesMessage;
	}

	public void setBytesMessage(byte[] bytesMessage) {
		this.bytesMessage = bytesMessage;
	}	
}