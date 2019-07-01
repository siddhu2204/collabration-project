package com.coll.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.UserDetail;

@Repository("userDao")
@Transactional
public class UserDetailDaoImpl implements UserDetailDao
{
@Autowired
SessionFactory sessionfactory;

	@Override
	public boolean registeruser(UserDetail user)
	{
	try
	{
		Session session=sessionfactory.getCurrentSession();
		session.save(user);	
		
		System.out.println("sent to database");
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
	}

	@Override
	public UserDetail getUser(String username)
	{
		Session session=sessionfactory.openSession();
		UserDetail user=session.get(UserDetail.class, username);
		session.close();
		return user;
		
		
	}

	@Override
	public boolean updateUser(UserDetail user)
	{
		try
		{
			sessionfactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	@Override
	public UserDetail checkuser(UserDetail user)
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("  from UserDetail  where username=:uname and password=:pwd");
		query.setParameter("uname", user.getUsername());
		query.setParameter("pwd",user.getPassword());
		List<UserDetail>listUsers=query.list();
		if(listUsers.size()>0)
		{
			return listUsers.get(0);
		}
		else
		{
			return null;
		}
	}

}
