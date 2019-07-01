package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table

public class ForumComment 
{
	
	@Id @GeneratedValue
	int commentid;
	int forumid;
	String commenttext;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYYY")
	Date commentDate;
	String username;
	
	
	public int getcommentid() {
		return commentid;
	}
	public void setcommentid(int fcommentid) {
		this.commentid = fcommentid;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}



	

}
