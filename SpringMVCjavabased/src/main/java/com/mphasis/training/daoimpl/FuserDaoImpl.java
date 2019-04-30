package com.mphasis.training.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.dao.FuserDao;
import com.mphasis.training.entities.Fuser;
@Repository
@Transactional
public class FuserDaoImpl implements FuserDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Fuser login(String email, String pass) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Fuser where email=:email and pass=:pass");
		query.setParameter("email", email);
		query.setParameter("pass", pass);
		Fuser fuser=(Fuser)query.uniqueResult();
		return fuser;
	}

	public void register(Fuser fuser) {
		// TODO Auto-generated method stub

	}

	public Fuser updatePassword(Fuser fuser) {
		// TODO Auto-generated method stub
		return null;
	}

}
