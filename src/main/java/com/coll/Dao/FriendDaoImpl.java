package com.coll.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao
{
	@Autowired
	SessionFactory sessionfactory;
	

	@Override
	public List<Friend> showFriendList(String username)
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Friend f where (f.username=:uname or friendusername=:fname) and  status='A'");
		query.setParameter("uname", username);
		query.setParameter("fname", username);
		List<Friend>friendlist=(List<Friend>)query.list();
		session.close();
		return friendlist;
	}

	@Override
	public List<Friend> showPendingList(String username)
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Friend f where f.username=:uname and status='P'");
		query.setParameter("uname", username);
		List<Friend>pendingfriendlist=query.list();
		return pendingfriendlist;
	}

	@Override
	public List<UserDetail> showSuggestedFriend(String username)
	{
		Session session=sessionfactory.openSession();
		Query sqlquery=session.createQuery("select username from UserDetail where username not in(Select friendusername from Friend where username='"+username+"') and username not in(select username from Friend where friendusername='"+username+"' and status='A')and username!='"+username+"'");
		List<String>userlist=(List<String>)sqlquery.list();
		ArrayList<UserDetail> userdetaillist=new ArrayList<UserDetail>();
		int i=0;
		while(i<userlist.size())
		{
			UserDetail user=session.get(UserDetail.class,userlist.get(i).toString().trim());
			userdetaillist.add(user);
			i++;
		}
		session.close();
		return userdetaillist;
		
	}

	@Override
	public boolean sendFriendRequest(Friend friend)
	{
		try
		{
			friend.setStatus("P");
			sessionfactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean acceptFriendRequest(int friendid)
	{
		try
		{
			Session session=sessionfactory.openSession();
			Friend friend=session.get(Friend.class, friendid);
			session.close();
			friend.setStatus("A");
			sessionfactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public boolean deleteFriendRequest(int friendid)
	{
		try
		{
		Session session=sessionfactory.openSession();
		Friend friend=session.get(Friend.class, friendid);
		session.close();
		sessionfactory.getCurrentSession().delete(friend);
		return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

}
