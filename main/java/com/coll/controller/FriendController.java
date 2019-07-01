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

import com.coll.Dao.FriendDao;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

@RestController
public class FriendController
{
@Autowired
FriendDao friendDao;

@GetMapping("/showFriendList/{username}")
public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username") String username)
{
	List<Friend>friendlist=friendDao.showFriendList(username);
	if(friendlist.size()>0)
	{
		return new ResponseEntity<List<Friend>>(friendlist,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<Friend>>(friendlist,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
@GetMapping("/showPendingList/{username}")
public ResponseEntity<List<Friend>> showPendingList(@PathVariable("username")String username)
{
	List<Friend>pendingfriendlist=friendDao.showPendingList(username);
	if(pendingfriendlist.size()>0)
	{
		return new ResponseEntity<List<Friend>>(pendingfriendlist,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<Friend>>(pendingfriendlist,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping(value="/sendFriendRequest",produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
{
	if(friendDao.sendFriendRequest(friend))
	{
		return new ResponseEntity<String>("Accepted",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("failure", HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
@PutMapping(value="/acceptFriendRequest/{friendid}",produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendid") int friendid)
{
	if(friendDao.acceptFriendRequest(friendid))
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@DeleteMapping(value="/deleteFriendRequest/{friendid}",produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendid")int friendid)
{
	if(friendDao.deleteFriendRequest(friendid))
	{
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/showSuggestedFriend/{username}")
public ResponseEntity<List<UserDetail>>showSuggestedFriend(@PathVariable("username")String username)
{
	List<UserDetail> suggestedlist=friendDao.showSuggestedFriend(username);
	{
		if(suggestedlist.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(suggestedlist,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(suggestedlist,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
}
