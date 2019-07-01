package com.coll.Dao;

import java.util.List;

import com.coll.model.ForumComment;

public interface ForumCommentDao
{
public boolean addComment(ForumComment comment);
public boolean deleteComment(ForumComment comment);
public ForumComment getForumComment(int commentid);
public List<ForumComment>listforumcomments(int forumid);

}
