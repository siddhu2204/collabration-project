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

import com.coll.Dao.BlogCommentDao;
import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;

@RestController
public class BlogCommentController
{

@Autowired
BlogCommentDao blogcommentDao;


@GetMapping("/showAllBlogComment/{blogid}")
public ResponseEntity<List<BlogComment>>showAllBlogComment(@PathVariable("blogid")int blogid)
{

	List<BlogComment>commentlist=blogcommentDao.listblogcomments(blogid);
	
	
	if(commentlist.size()>0)
	{
		return new ResponseEntity<List<BlogComment>>(commentlist,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<BlogComment>>(commentlist,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
@PostMapping(value="/addBlogComment",produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> addBlogComment( @RequestBody BlogComment comment)
{   
	      comment.setCommentDate(new java.util.Date());
	      comment.setUsername("lalitha");
	      
	     if(blogcommentDao.addComment(comment))
	      {
	    	  return new ResponseEntity<String>("Blogcommentadded",HttpStatus.OK);
	      }
	      else
	      {
	    	  return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
	      }
}
@GetMapping("/getBlogComment/{commentid}")
public ResponseEntity<BlogComment>getBlogComment(@PathVariable("commentid")int commentid)
{
	 BlogComment comment=(BlogComment)blogcommentDao.getBlogComment(commentid);
	return new ResponseEntity<BlogComment>(comment,HttpStatus.OK);
}


@DeleteMapping("/deleteBlogComment/{commentid}")
public ResponseEntity<BlogComment> deleteBlogComment(@PathVariable("commentid") int commentid)
{
    System.out.println("Fetching & Deleting comment with id " + commentid);

     BlogComment comment=blogcommentDao.getBlogComment(commentid);
    if (comment == null) 
    {
        System.out.println("Unable to delete comment with id " + commentid + " not found");
        return new ResponseEntity<BlogComment>(HttpStatus.NOT_FOUND);
    }
    else
    {

    blogcommentDao.deleteComment(comment);
    return new ResponseEntity<BlogComment>(HttpStatus.OK);
}
}

}

