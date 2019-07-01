package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BlogComment
{
@Id @GeneratedValue
int commentid;
int blogid;
String commenttext;
Date commentDate;
String username;
public int getCommentid() {
	return commentid;
}
public void setCommentid(int commentid) {
	this.commentid = commentid;
}
public int getBlogid() {
	return blogid;
}
public void setBlogid(int blogid) {
	this.blogid = blogid;
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
