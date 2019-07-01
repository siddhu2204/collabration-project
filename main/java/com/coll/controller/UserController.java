package com.coll.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.coll.Dao.UserDetailDao;

import com.coll.model.UserDetail;

@RestController
public class UserController
{
@Autowired
UserDetailDao userDao;
@PostMapping(value="/registerUser", produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String>registerUser(@RequestBody UserDetail user)
{
	user.setRole("User");
	user.setStatus("A");
	user.setIsonline("Y");
	System.out.println(user.getEmailid());
System.out.println(user.getPassword());
	//user.setEmailId("s.raja96@gmail.com");
	//user.setPassword("Siddhu@1996");
			
	if(userDao.registeruser(user))
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping(value="/checkUser")
public ResponseEntity<UserDetail> checkUser(@RequestBody UserDetail user,HttpSession session)
{
	UserDetail user1=userDao.checkuser(user);
	if(user1!=null)
	{
		session.setAttribute("user", user1);
		return new ResponseEntity<UserDetail>(user1,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<UserDetail>(user1,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@PostMapping(value="/updateUser",produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String>updateUser(@RequestBody UserDetail user)
{
	UserDetail user1=userDao.getUser(user.getUsername());
	user.setRole(user1.getRole());
	user.setStatus(user1.getStatus());
	user.setIsonline(user1.getIsonline());
	//user.setEmailId(user1.getEmailId());
			
	if(userDao.updateUser(user))
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	@PostMapping("/getUser/{username}")
	public ResponseEntity<UserDetail>getUser(@PathVariable("username") String username)
	{
		UserDetail user=(UserDetail)userDao.getUser(username);
		return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
		
	}
}
