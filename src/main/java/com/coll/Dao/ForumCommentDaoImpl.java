package com.coll.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.BlogComment;
import com.coll.model.ForumComment;

@Repository("forumcommentDao")
@Transactional

public class ForumCommentDaoImpl  implements ForumCommentDao
{
@Autowired
SessionFactory sessionfactory;

	@Override
	public boolean addComment(ForumComment comment)
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
	public boolean deleteComment(ForumComment comment)
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
	public ForumComment getForumComment(int commentid)
	{
		Session session=sessionfactory.openSession();
		ForumComment comment=session.get(ForumComment.class, commentid);
		session.close();
		return comment;
	}

	@Override
	public List<ForumComment> listforumcomments(int forumid)
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from ForumComment f where f.forumid=:forumid");
		query.setParameter("forumid", 89);
		List<ForumComment>listforumcomments=query.list();
		return listforumcomments ;
	}

}
