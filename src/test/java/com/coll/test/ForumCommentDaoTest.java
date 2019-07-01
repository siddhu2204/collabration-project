package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.Dao.ForumCommentDao;
import com.coll.model.BlogComment;
import com.coll.model.ForumComment;



public class ForumCommentDaoTest
{ 
static ForumCommentDao forumcommentDao;
	
	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
	forumcommentDao=(ForumCommentDao)context.getBean("forumcommentDao");	
	//blogcommentDao=(BlogCommentDao)context.getBean("blogcommentDao");
	}
	@Ignore
	@Test
	public void addForumCommenttest() 
	{
		ForumComment comment=new ForumComment();
		comment.setForumid(89);
		comment.setCommentDate(new java.util.Date());
		comment.setCommenttext("hi hello");
		comment.setUsername("mathi");
		assertTrue(forumcommentDao.addComment(comment));
	}
	@Ignore
	@Test
	public void deleteForumCommentTest()
	{
		ForumComment comment=forumcommentDao.getForumComment(89);
		assertTrue(forumcommentDao.deleteComment(comment)); 	
	}
	
	@Test
	public void listforumcommentTest()
	{
		List<ForumComment>commentlist=forumcommentDao.listforumcomments(89);
		assertTrue(commentlist.size()>0);
		for(ForumComment comment:commentlist)
		{
			System.out.println(comment.getCommenttext());
		
		}
	}
}
