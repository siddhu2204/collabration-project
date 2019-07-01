package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="joboffer")
public class Job
{
@Id
@GeneratedValue
 int jobid;
String jobdesignation;
String companyname;
int ctc;
String location;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYYY")
Date lastdatetoapply;
String skills;
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public String getJobdesignation() {
	return jobdesignation;
}
public void setJobdesignation(String jobdesignation) {
	this.jobdesignation = jobdesignation;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public int getCtc() {
	return ctc;
}
public void setCtc(int ctc) {
	this.ctc = ctc;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getSkills() {
	return skills;
}
public Date getLastdatetoapply() {
	return lastdatetoapply;
}
public void setLastdatetoapply(Date lastdatetoapply) {
	this.lastdatetoapply = lastdatetoapply;
}
public void setSkills(String skills) {
	this.skills = skills;
}

}
