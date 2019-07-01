package com.coll.Dao;

import java.util.List;

import com.coll.model.Blog;

public interface BlogDao
{
public boolean addBlog(Blog blog);
public boolean deleteBlog(Blog blog);
public boolean updateBlog(Blog blog);
public List<Blog>listblogs();
public boolean approveBlog(Blog blog);
public boolean rejectBlog(Blog blog);
public boolean incrementLikes(int blogid);
public boolean incrementdisLikes(int blogid);
public Blog getBlog(int blogid);



}
