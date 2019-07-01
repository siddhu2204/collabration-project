package com.coll.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DBConfig.DBConfig;
import com.coll.Dao.BlogDao;
import com.coll.model.Blog;


public class BlogDaoTest
{

static	 BlogDao blogDao;
	
	@BeforeClass
	public static  void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogDao=(BlogDao)context.getBean("blogDao");

	}
	
	
	
	@Ignore
	@Test
	public void addBlogtest()
	{
		Blog blog=new Blog();
		blog.setBlogname("automobile");
		blog.setBlogcontent("changing towards electric");
		blog.setUsername("dinesh");
		blog.setCreateDate(new Date());
		blog.setLikes(100);
		blog.setDislikes(6);
		blog.setStatus("A");
		assertTrue(blogDao.addBlog(blog));
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDao.getBlog(2);
		assertTrue(blogDao.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDao.getBlog(1);
		blog.setBlogcontent("Mechanical is a powerful stream in Engineering");
		blog.setBlogname("Mechanical Enginnering");
		assertTrue(blogDao.updateBlog(blog));
		}
		
	@Test
	public void listBlogTest()
	{
	List<Blog>blogList=blogDao.listblogs();
	assertTrue(blogList.size()>0);
	for(Blog blog:blogList)
	{
		System.out.print(blog.getBlogid()+":::");
		System.out.print(blog.getBlogname()+":::");
		System.out.print(blog.getBlogcontent()+":::");
		System.out.print(blog.getStatus()+":::");
	}
	}
	@Ignore
	@Test
	public void approveBlogTest()
	{
	Blog blog=blogDao.getBlog(5);
	assertTrue(blogDao.approveBlog(blog));
	}
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDao.getBlog(6);
		assertTrue(blogDao.rejectBlog(blog));
	}
	
	@Test
	public void incrementLikesTest()
	{
		System.out.println("hi to increment");
		assertTrue(blogDao.incrementLikes(1));
		
	}
	
	@Test
	public void incrementDisLikesTest()
	{
		System.out.println("hi to decrement");
		assertTrue(blogDao.incrementdisLikes(19));
	}
	}




	