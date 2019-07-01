package com.coll.Dao;

import java.util.List;
import com.coll.model.Forum;

public interface ForumDao 
{
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public List<Forum>listforums();
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public boolean incrementLikes(int forumid);
	public boolean incrementdisLikes(int forumid);
	public Forum getForum(int forumid);
}
