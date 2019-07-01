package com.coll.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coll.Dao.ProfilePictureDao;
import com.coll.model.ProfilePicture;
import com.coll.model.UserDetail;

@RestController
public class PictureRestController
{

	@Autowired
	ProfilePictureDao profilepictureDao;
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadPicture(@RequestParam(value="file")	CommonsMultipartFile fileupload,HttpSession session)
	{
		UserDetail user=(UserDetail)session.getAttribute("user");
		
		if(user==null)
		{
			return new ResponseEntity<String>("Unauthorized User",HttpStatus.NOT_FOUND);
		}
		else
		{
			ProfilePicture picture=new ProfilePicture();
			picture.setUsername(user.getUsername());
			picture.setImage(fileupload.getBytes());
			System.out.println("i am in do upload");
			profilepictureDao.save(picture);
			System.out.println("After Save");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	
	@RequestMapping(value="/getImage/{username}")
	public @ResponseBody byte[] getProfilePicture(@PathVariable("username") String username,HttpSession session)
	{
		UserDetail user=(UserDetail)session.getAttribute("user");
		
		if(user==null)
		{
			return null;
		}
		else
		{
			ProfilePicture picture=profilepictureDao.getProfilePicture(user.getUsername());
			
			if(picture!=null)
			{
				return picture.getImage();
			}
			else
			{
				return null;
			}
		}
	}
}
