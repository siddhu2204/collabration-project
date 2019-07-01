package com.coll.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Blog;
import com.coll.model.Forum;

@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements  ForumDao
{
@Autowired
SessionFactory sessionfactory;
	@Override
	public boolean addForum(Forum forum)
	{
		try
		{
			//Session session=sessionfactory.openSession();
			sessionfactory.getCurrentSession().save(forum);
			
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public boolean deleteForum(Forum forum)
	{
		try
		{
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
	}

	@Override
	public boolean updateForum(Forum forum)
	{
		try
		{
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public List<Forum> listforums()
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum>listforums=query.list();
		session.close();
		return listforums ;
	}

	@Override
	public boolean approveForum(Forum forum) 
	{
		try
		{
			forum.setStatus("A");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean rejectForum(Forum forum)
	{
		try
		{
			forum.setStatus("NA");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	@Override
	public boolean incrementLikes(int forumid) 
	{
		try
		{
		Forum forum=this.getForum(forumid);
		forum.setLikes(forum.getLikes()+1);
		sessionfactory.getCurrentSession().update(forum);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean incrementdisLikes(int forumid)
	{
		try
		{
			Forum forum=this.getForum(forumid);
			System.out.println(forum);
			forum.setDislikes(forum.getDislikes()+1);
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Forum getForum(int forumid)
	{
		Session session=sessionfactory.openSession();
		Forum forum=session.get(Forum.class, forumid);
		return forum ;
	}

}
