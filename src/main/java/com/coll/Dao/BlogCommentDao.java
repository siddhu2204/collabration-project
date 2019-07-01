package com.coll.Dao;

import java.util.List;

import com.coll.model.BlogComment;

public interface BlogCommentDao
{
public boolean addComment(BlogComment comment);
public boolean deleteComment(BlogComment comment);
public BlogComment getBlogComment(int commentid);
public List<BlogComment>listblogcomments(int blogid);

}
