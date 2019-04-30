package com.mphasis.training.services;

import com.mphasis.training.entities.Fuser;

public interface FuserService {
	public Fuser login(String email,String pass);
	public void register(Fuser fuser);
	public Fuser updatePassword(Fuser fuser);
}
