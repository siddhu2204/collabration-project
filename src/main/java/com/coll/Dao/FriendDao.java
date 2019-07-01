package com.coll.Dao;

import java.util.List;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

public interface FriendDao 
{
public List<Friend> showFriendList(String username);
public List<Friend> showPendingList(String username);
public List<UserDetail> showSuggestedFriend(String username);
public boolean sendFriendRequest(Friend friend);
public boolean acceptFriendRequest(int friendid);
public boolean deleteFriendRequest(int friendid);
}
