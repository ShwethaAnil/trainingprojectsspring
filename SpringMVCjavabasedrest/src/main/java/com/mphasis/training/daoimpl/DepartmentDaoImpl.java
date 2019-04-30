package com.mphasis.training.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.dao.DepartmentDao;
import com.mphasis.training.entities.Department;
import com.mphasis.training.entities.Employee;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void insertDepartment(Department e) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(e);
		tr.commit();
		session.close();
	}


	public void updateDepartment(Department e) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(e);
		tr.commit();
		session.close();
	}


	public void deleteDepartment(int id) {
		Session session=sessionFactory.openSession();
		Department department=(Department)session.get(Department.class, id);
		Transaction tr=session.beginTransaction();
		session.delete(department);
		tr.commit();
		session.close();
		
	}


	public Department getDepartmentById(int id) {
		Session session=sessionFactory.openSession();
		Department department=(Department)session.get(Department.class, id);
		Transaction tr=session.beginTransaction();
		
		tr.commit();
		session.close();
		return department;
	}


	public List<Department> getAll() {
		Session session=sessionFactory.openSession();
		List<Department> departments=session.createCriteria(Department.class).list();
		return departments;
	}
}
