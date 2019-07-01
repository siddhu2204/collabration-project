package com.coll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="Friend", sequenceName="friendseq")
public class Friend 
{
@Id 
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Friend")
int friendid;
String username;
String friendusername;
String status;
public int getFriendid() {
	return friendid;
}
public void setFriendid(int friendid) {
	this.friendid = friendid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFriendusername() {
	return friendusername;
}
public void setFriendusername(String friendusername) {
	this.friendusername = friendusername;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
