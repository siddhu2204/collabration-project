package com.coll.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.coll.Dao.ForumDao;
import com.coll.model.Blog;
import com.coll.model.Forum;

@RestController
public class ForumController 
{
@Autowired
ForumDao forumDao;


@GetMapping("/showAllForum")
public ResponseEntity<List<Forum>>showAllForum()
{

	List<Forum>listforums=forumDao.listforums();
	
	if(listforums.size()>0)
	{
		return new ResponseEntity<List<Forum>>(listforums,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<Forum>>(listforums,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}

@GetMapping("/getForum/{forumid}")
public ResponseEntity<Forum>getForum(@PathVariable("forumid")int forumid)
{
	Forum forum=(Forum)forumDao.getForum(forumid);
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	
}

 @DeleteMapping("/deleteForum/{forumid}")
	    public ResponseEntity<Forum> deleteForum(@PathVariable("forumid") int forumid)
	 {
	        System.out.println("Fetching & Deleting forum with id " + forumid);
	  
	        Forum forum=forumDao.getForum(forumid);
	        if (forum == null) 
	        {
	            System.out.println("Unable to delete. forum with id " + forumid + " not found");
	            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	        }
	        else
	        {
	  
	        forumDao.deleteForum(forum);
	        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	    }
	 }
 
 @PutMapping("/updateForum/")
 public ResponseEntity<Forum> updateForum( @RequestBody Forum forum)
 {
		        
	          
	        if (forum==null)
	        {
	            
	            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	        }
	       
	        forumDao.updateForum(forum);  
	        return new ResponseEntity<Forum>(forum, HttpStatus.OK);
 }
 
 @PostMapping(value="/addForum",produces=MediaType.TEXT_PLAIN)
 public ResponseEntity<String> addForum( @RequestBody Forum forum)
 {   
	 
	 		forum.setCreateDate(new java.util.Date());
	 		forum.setDislikes(22);
	 		forum.setLikes(66);
	 		//forum.setForumcontent("hi to postman");
	 		forum.setStatus("A");
	 		
	      if(forumDao.addForum(forum))
	      {
	    	  return new ResponseEntity<String>("forumadded",HttpStatus.OK);
	      }
	      else
	      {
	    	  return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
	      }
 }
 

	@GetMapping(value="/approveForum/{forumid}",produces=MediaType.TEXT_PLAIN)
	public ResponseEntity<String>approveForum(@PathVariable("forumid")int forumid)
	{
		Forum forum=(Forum)forumDao.getForum(forumid);
	
		if(forumDao.approveForum(forum))
		{
			return new ResponseEntity<String>("approved",HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
	@GetMapping(value="/rejectForum/{forumid}",produces=MediaType.TEXT_PLAIN)
	public ResponseEntity<String>rejectForum(@PathVariable("forumid")int forumid)
	{
		Forum forum=(Forum)forumDao.getForum(forumid);
	
		if(forumDao.rejectForum(forum))
		{
			return new ResponseEntity<String>("rejected",HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	@GetMapping(value="/incrementlikes/{forumid}",produces=MediaType.TEXT_PLAIN)
	public ResponseEntity<String>incrementlikes(@PathVariable("forumid")int forumid)
	{
		
		if(forumDao.incrementLikes(forumid))
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	@GetMapping(value="/incrementdislikes/{forumid}",produces=MediaType.TEXT_PLAIN)
	public ResponseEntity<String>incrementdislikes(@PathVariable("forumid")int forumid)
	{
		
		if(forumDao.incrementdisLikes(forumid))
		{
			return new ResponseEntity<String>("decremented",HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	

}
 



