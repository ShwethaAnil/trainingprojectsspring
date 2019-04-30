package com.mphasis.training.dao;

import com.mphasis.training.entities.Fuser;

public interface FuserDao {
	public Fuser login(String email,String pass);
	public void register(Fuser fuser);
	public Fuser updatePassword(Fuser fuser);

}
