package com.coll.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Blog;

@Repository("blogDao")
@Transactional
		public class BlogDaoImpl implements BlogDao
{
@Autowired
SessionFactory sessionfactory;

	@Override
	public boolean addBlog(Blog blog)
	{
		System.out.println("Blog "+blog.getBlogcontent());
		try
		{
			sessionfactory.getCurrentSession().save(blog);
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		return false;
		}
		
	}

	@Override
	public boolean deleteBlog(Blog blog)
	{
		try
		{
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	@Override
	public boolean updateBlog(Blog blog) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}


	@Override
	public List<Blog> listblogs() 
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Blog b");
		List<Blog>listblogs=query.list();
		System.out.println(listblogs);
		session.close();
		return listblogs ;
	}

	@Override
	public boolean approveBlog(Blog blog)
	{
		try
		{
			blog.setStatus("A");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog)
	{
		try
		{
			blog.setStatus("NA");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}	
	
	@Override
	public boolean incrementLikes(int blogid)
	{
		try
		{
		Blog blog=this.getBlog(blogid);
		System.out.println(blog);
		blog.setLikes(blog.getLikes()+1);
		sessionfactory.getCurrentSession().update(blog);
		
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	
	}
	@Override
	public boolean incrementdisLikes(int blogid)
	{
		try
		{
		Blog blog=this.getBlog(blogid);
		System.out.println(blog);
		blog.setDislikes(blog.getDislikes()+1);
		sessionfactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Blog getBlog(int blogid)
	{
		Session session=sessionfactory.openSession();
		Blog blog=session.find(Blog.class, blogid);
		
		return blog;
	}

}
