
package com.coll.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.ProfilePicture;

@Repository("profilepictureDao")
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao

{
@Autowired
SessionFactory sessionfactory;

@Override
public boolean save(ProfilePicture picture) 
{
	try
	{
	Session session=sessionfactory.getCurrentSession();
	session.saveOrUpdate(picture);
	session.flush();
	//session.close();
	return true;
}
	catch(Exception e)
	{
		System.out.println("Exception:" + e);
		return false;
	}
}
@Override
public ProfilePicture getProfilePicture(String username) 
{
	Session session=sessionfactory.openSession();
	ProfilePicture picture=session.get(ProfilePicture.class, username);
	session.close();
	return picture;
	
}

}
