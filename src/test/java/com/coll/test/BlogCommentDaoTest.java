package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.Dao.BlogCommentDao;
import com.coll.model.Blog;
import com.coll.model.BlogComment;


public class BlogCommentDaoTest 
{
static BlogCommentDao blogcommentDao;
	
	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
	blogcommentDao=(BlogCommentDao)context.getBean("blogcommentDao");
	} 
	@Ignore
	@Test
	public void addBlogCommenttest() 
	{
		BlogComment comment=new BlogComment() ;
		comment.setBlogid(56);
		comment.setCommentDate(new java.util.Date());
		comment.setCommenttext("hi to RestController");
		comment.setUsername("siddhusubramanian");
		assertTrue(blogcommentDao.addComment(comment));
	}
	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		BlogComment comment=blogcommentDao.getBlogComment(3);
		assertTrue(blogcommentDao.deleteComment(comment));	
	}
	
	@Test
	public void listblogcommentTest()
	{
		List<BlogComment>commentlist=blogcommentDao.listblogcomments(5);
		assertTrue(commentlist.size()>0);
		for(BlogComment comment:commentlist)
		{
			//System.out.print(comment.getBlogid()+":::");
			System.out.print(comment.getCommentid()+":::");
			System.out.print(comment.getCommenttext()+":::");
			System.out.print(comment.getUsername()+":::");
		}
		
	}
}
