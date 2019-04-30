package com.mphasis.training.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.FuserDao;
import com.mphasis.training.entities.Fuser;
import com.mphasis.training.services.FuserService;

@Service
public class FuserServiceImpl implements FuserService {

	@Autowired
	FuserDao fuserDao;
	
	public FuserDao getFuserDao() {
		return fuserDao;
	}

	public void setFuserDao(FuserDao fuserDao) {
		this.fuserDao = fuserDao;
	}

	public Fuser login(String email, String pass) {
		// TODO Auto-generated method stub
		return fuserDao.login(email, pass);
	}

	public void register(Fuser fuser) {
		// TODO Auto-generated method stub

	}

	public Fuser updatePassword(Fuser fuser) {
		// TODO Auto-generated method stub
		return null;
	}

}
