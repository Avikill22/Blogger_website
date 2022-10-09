package com.backend.blogBackend.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")

public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@Column(name="description")
	private String description;
	
	@Column(length = 200000)
	private byte[] imgByte;
	
	@Column(name = "post_title",length = 100, nullable = false)
	private String title;
	
	@Column(name="date")
	private Date addedDate;
	
	@Column(name="active_flag")
	private Boolean active;
	
	private User user;
	
	public Post() {
		super();
		
	}

	public Post(Integer postId, String description, byte[] imgByte, String title, Date addedDate, Boolean active) {
		super();
		this.postId = postId;
		this.description = description;
		this.imgByte = imgByte;
		this.title = title;
		this.addedDate = addedDate;
		this.active = active;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
