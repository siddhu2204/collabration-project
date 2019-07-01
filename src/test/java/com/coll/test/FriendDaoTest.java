package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.Dao.FriendDao;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

public class FriendDaoTest
{
static FriendDao friendDao;

@BeforeClass
public static void executefirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.coll");
	context.refresh();
	friendDao=(FriendDao)context.getBean("friendDao");
}
	
	@Test
	public void  sendFriendRequestTest()
	{
		Friend friend=new Friend();
		friend.setUsername("Maddy");
		friend.setFriendusername("Athavan");
		assertTrue(friendDao.sendFriendRequest(friend));
	}
	@Ignore
	@Test
	public void acceptFriendRequest()
	{
		assertTrue(friendDao.acceptFriendRequest(53));
	}
	@Ignore
	@Test
	public void showFriendList()
	{
		List<Friend>friendlist=friendDao.showFriendList("siddhu");
		assertTrue(friendlist.size()>0);
		for(Friend friend:friendlist)
		{
			System.out.println(friend.getFriendusername() + ":::");
			System.out.println(friend.getUsername() + ":::");
			System.out.println(friend.getFriendid() + "::::");
			System.out.println(friend.getStatus() + ":::");
			
		}
		
	}
	@Ignore
	@Test
	public void showPendingList()
	{
		List<Friend>pendingfriendlist=friendDao.showPendingList("siddhu");
		assertTrue(pendingfriendlist.size()>0);
		for(Friend friend:pendingfriendlist)
		{
			System.out.println(friend.getFriendusername());
			System.out.println(friend.getFriendid());
			System.out.println(friend.getStatus());
			System.out.println(friend.getUsername());
		}
	}	@Ignore
		@Test
		public void deleteFriendRequestTest()
		{
			
			assertTrue(friendDao.deleteFriendRequest(54));
			
			
		}
		@Ignore
		@Test
		public void showSuggestedFriendTest()
		{
			List<UserDetail> userdetaillist=friendDao.showSuggestedFriend("siddhu");
			assertTrue(userdetaillist.size()>0);
			for(UserDetail user:userdetaillist)
			{
				System.out.println(user.getUsername());
				System.out.println(user.getStatus());
			}
		}
}


