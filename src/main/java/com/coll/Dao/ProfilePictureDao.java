package com.coll.Dao;

import com.coll.model.ProfilePicture;

public interface ProfilePictureDao
{
public boolean save(ProfilePicture picture);
public ProfilePicture getProfilePicture(String username);

}
