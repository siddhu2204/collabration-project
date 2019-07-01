package com.coll.Dao;

import com.coll.model.UserDetail;

public interface UserDetailDao
{
public boolean registeruser(UserDetail user);
public UserDetail getUser(String username);
public boolean updateUser(UserDetail user);
public UserDetail checkuser(UserDetail user);


}
