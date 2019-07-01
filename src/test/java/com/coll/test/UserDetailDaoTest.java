package com.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DBConfig.DBConfig;
import com.coll.Dao.UserDetailDao;
import com.coll.model.UserDetail;


public class UserDetailDaoTest
{
static	UserDetailDao userDao;
	
	@BeforeClass
	public static  void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		context.scan("com.coll");
		userDao=(UserDetailDao)context.getBean("userDao");
	}
	@Ignore
	@Test
	public void registeruserTest()
	{
		UserDetail user=new UserDetail();
		user.setEmailid("ara@gmail.com");
		user.setIsonline("Y");
		user.setMemberName("Ara Athavan");
		user.setPassword("Ara@2019");
		user.setRole("User");
		user.setStatus("A");
		user.setUsername("Athavan");
		assertTrue(userDao.registeruser(user));	
	}
	@Ignore
	@Test
	public void updateUsertest()
	{
		UserDetail user=userDao.getUser("Athavan");
		user.setEmailid("ara@hotmail.com");
		user.setMemberName("Athavan");
		assertTrue(userDao.updateUser(user));
	}
	
	@Test
	public void checkUsertest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("Athavan");
		user.setPassword("ara061995");
		UserDetail user1=userDao.checkuser(user);
		assertNotNull("problem in login credential",user1);
		System.out.println("name:" +user1.getMemberName());
		System.out.println(user1.getRole());
		
		}
}
	
