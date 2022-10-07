package com.backend.blogBackend.VO;

import javax.persistence.Column;

public class PostVo {

	private int postId;
	private String description;
	private byte[] imgByte;
	private int userId;
	private String title;
	private boolean active;
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public PostVo() {
		
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImgByte() {
		return imgByte;
	}
	public void setImgByte(byte[] imgByte) {
		this.imgByte = imgByte;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
