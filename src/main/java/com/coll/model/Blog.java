package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Blog_value")
public class Blog
{
@Id @GeneratedValue
int blogid;
String blogname;
String blogcontent;
String username;
String status;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYYY")
Date createDate;
int likes;
int dislikes;
public int getBlogid() {
	return blogid;
}
public void setBlogid(int blogid) {
	this.blogid = blogid;
}
public String getBlogname() {
	return blogname;
}
public void setBlogname(String blogname) {
	this.blogname = blogname;
}
public String getBlogcontent() {
	return blogcontent;
}
public void setBlogcontent(String blogcontent) {
	this.blogcontent = blogcontent;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public int getDislikes() {
	return dislikes;
}
public void setDislikes(int dislikes) {
	this.dislikes = dislikes;
}
}
