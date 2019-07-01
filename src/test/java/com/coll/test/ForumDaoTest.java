package com.coll.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DBConfig.DBConfig;
import com.coll.Dao.ForumDao;
import com.coll.model.Blog;
import com.coll.model.Forum;

public class ForumDaoTest 
{
static ForumDao forumDao;

@BeforeClass
public static void executefirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
	context.scan("com.coll");
	//context.refresh();
	forumDao=(ForumDao)context.getBean("forumDao");
}	
	@Ignore
	@Test
	public void addForumtest()
	{
		Forum forum=new Forum();
		forum.setCreateDate(new Date());
		forum.setDislikes(1);
		forum.setForumcontent("welcome");
		forum.setForumid(123);
		forum.setForumname("Siddhu");
		forum.setLikes(2);
		forum.setStatus("A");
		forum.setUsername("Subramanian");
		assertTrue(forumDao.addForum(forum));	
	}
	@Ignore
	@Test
	public void deleteForumtest()
	{
		Forum forum=forumDao.getForum(3);
		assertTrue(forumDao.deleteForum(forum));
	}
	@Ignore
	@Test
	public void updateForumtest()
	{
		Forum forum=forumDao.getForum(4);
		forum.setLikes(1);
		forum.setStatus("NA");
		assertTrue(forumDao.updateForum(forum));
	}
	@Ignore
	@Test
	public void listForumstest()
	{
		List<Forum>forumlist=forumDao.listforums();
		assertTrue(forumlist.size()>0);
		
		
		for(Forum forum:forumlist)
		{
			System.out.println(forum.getForumname());
			System.out.println(forum.getUsername());
			System.out.println(forum.getLikes());
			
		}
	}
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=forumDao.getForum(13);
	
	assertTrue(forumDao.approveForum(forum));
	}
	@Ignore
	@Test
	public void rejectForumTest()
	{
		Forum forum=forumDao.getForum(3);
		
		assertTrue(forumDao.rejectForum(forum));
		
	}
	@Ignore
	@Test
	public void incrementLikesTest()
	{
		System.out.println("hi to increment");
		assertTrue(forumDao.incrementLikes(81));
		Forum forum=new Forum();
	//System.out.println(forum.getLikes());
		
	}

	@Test
	public void incrementDisLikesTest()
	{
		System.out.println("hi to decrement");
		assertTrue(forumDao.incrementdisLikes(81));
	}
	}


