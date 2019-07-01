package com.coll.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.BlogComment;

@Repository("blogcommentDao")
@Transactional

public class BlogCommentDaoImpl implements BlogCommentDao
{
@Autowired
SessionFactory sessionfactory;

	@Override
	public boolean addComment(BlogComment comment)
	{
		try
		{
			sessionfactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e)
		{
		return false; 
		}
	}
	@Override
	public boolean deleteComment(BlogComment comment)
	{
		try
		{
			sessionfactory.getCurrentSession().delete(comment);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	@Override
	public BlogComment getBlogComment(int commentid)
	{
		Session session=sessionfactory.openSession();
		BlogComment comment=session.get(BlogComment.class, commentid);
		session.close();
		return comment;
	}

	@Override
	public List<BlogComment> listblogcomments(int blogid)
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from BlogComment b where b.blogid=:blogid");
		query.setParameter("blogid", 5);
		List<BlogComment>listblogcomments=query.list();
		return listblogcomments ;
	}

}
