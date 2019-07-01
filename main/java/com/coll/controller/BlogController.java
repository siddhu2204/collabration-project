package com.coll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.Dao.BlogDao;
import com.coll.model.Blog;
import com.coll.model.Forum;

@RestController
public class BlogController
{

@Autowired
BlogDao blogDao;

@GetMapping("/showAllBlogs")
public ResponseEntity<List<Blog>>showAllBlogs()
{

	List<Blog>blogList=blogDao.listblogs();
	
	if(blogList.size()>0)
	{
		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
		
	@GetMapping(value="/getBlog/{blogid}")
	public ResponseEntity<Blog>getBlog(@PathVariable("blogid")int blogid)
	{
		Blog blog=(Blog)blogDao.getBlog(blogid);

		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		
	}

	@GetMapping(value="/rejectBlog/{blogid}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String>rejectBlog(@PathVariable("blogid")int blogid)
	{
		Blog blog=(Blog)blogDao.getBlog(blogid);
		if(blogDao.rejectBlog(blog))
		{
			return new ResponseEntity<String>("rejected",HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		@GetMapping(value="/approveBlog/{blogid}",produces=MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity<String>approveBlog(@PathVariable("blogid")int blogid)
		{
			Blog blog=(Blog)blogDao.getBlog(blogid);
			if(blogDao.approveBlog(blog))
			{
				return new ResponseEntity<String>("approved",HttpStatus.OK);
			}
			else
			{
			return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
		
		@GetMapping(value="/incrementLikes/{blogid}",produces=MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity<String>incrementLikes(@PathVariable("blogid")int blogid)
		{
			
			if(blogDao.incrementLikes(blogid))
			{
				return new ResponseEntity<String>("incremented",HttpStatus.OK);
			}
			else
			{
			return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
		
		@GetMapping(value="/incrementdisLikes/{blogid}", produces=MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity<String>incrementdisLikes(@PathVariable("blogid")int blogid)
		{
			
			if(blogDao.incrementdisLikes(blogid))
			{
				return new ResponseEntity<String>("decremented",HttpStatus.OK);
			}
			else
			{
			return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
		
		
	 @PostMapping(value="/addBlog",produces=MediaType.TEXT_PLAIN_VALUE)
	 public ResponseEntity<String> addBlog( @RequestBody Blog blog)
	 {   
		      blog.setCreateDate(new java.util.Date());
		      blog.setLikes(25);
		      blog.setDislikes(5);
		      //blog.setUsername("mathi");
		      blog.setStatus("NA");
		      if(blogDao.addBlog(blog))
		      {
		    	  return new ResponseEntity<String>("Blogadded",HttpStatus.OK);
		      }
		      else
		      {
		    	  return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		      }
	 }
	 @PutMapping("/updateBlog/")
	 public ResponseEntity<Blog> updateBlog( @RequestBody Blog blog)
	 {    
		        if (blog==null)
		        {
		            
		            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		        }
		       
		        blogDao.updateBlog(blog);  
		        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/deleteBlog/{blogid}")
	    public ResponseEntity<Blog> deleteBlog(@PathVariable("blogid") int blogid)
	 {
	        System.out.println("Fetching & Deleting blog with id " + blogid);
	  
	     Blog blog=blogDao.getBlog(blogid);
	        if (blog == null) 
	        {
	            System.out.println("Unable to delete blog with id " + blogid + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	        else
	        {
	  
	        blogDao.deleteBlog(blog);
	        return new ResponseEntity<Blog>(HttpStatus.OK);
	    }
	 }
	 
}