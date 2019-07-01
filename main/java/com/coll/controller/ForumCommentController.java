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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.Dao.ForumCommentDao;
import com.coll.model.ForumComment;


@RestController
public class ForumCommentController
{

@Autowired
ForumCommentDao forumcommentDao;


@GetMapping("/showAllForumComment/{forumid}")
public ResponseEntity<List<ForumComment>>showAllFroumComment(@PathVariable("forumid")int forumid)
{

	List<ForumComment>commentlist=forumcommentDao.listforumcomments(forumid);
	
	
	if(commentlist.size()>0)
	{
		return new ResponseEntity<List<ForumComment>>(commentlist,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<ForumComment>>(commentlist,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
@PostMapping(value="/addForumComment",produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> addForumComment( @RequestBody ForumComment comment)
{   
	      comment.setCommentDate(new java.util.Date());
	      //fcomment.setUsername("lalitha");
	      
	     if(forumcommentDao.addComment(comment))
	      {
	    	  return new ResponseEntity<String>("Forumcommentadded",HttpStatus.OK);
	      }
	      else
	      {
	    	  return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
	      }
}
@GetMapping("/getForumComment/{commentid}")
public ResponseEntity<ForumComment>getForumComment(@PathVariable("commentid")int commentid)
{
	 ForumComment comment=(ForumComment)forumcommentDao.getForumComment(commentid);
	return new ResponseEntity<ForumComment>(comment,HttpStatus.OK);
}


@DeleteMapping("/deleteForumComment/{commentid}")
public ResponseEntity<ForumComment> deleteFroumComment(@PathVariable("commentid") int commentid)
{
    System.out.println("Fetching & Deleting comment with id " + commentid);

     ForumComment comment=forumcommentDao.getForumComment(commentid);
    if (comment == null) 
    {
        System.out.println("Unable to delete comment with id " + commentid + " not found");
        return new ResponseEntity<ForumComment>(HttpStatus.NOT_FOUND);
    }
    else
    {

    forumcommentDao.deleteComment(comment);
    return new ResponseEntity<ForumComment>(HttpStatus.OK);
}
}

}

