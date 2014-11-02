package com.edsolstice.educationportal.dbmodel;

import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DbMgr {

	private SessionFactory sessionFactory;
	private static DbMgr _instance ; 

	private DbMgr() {
		
        sessionFactory =  new Configuration().
        		configure("hibernate.cfg.xml").buildSessionFactory();

	}
	

	
	/**
	 * 
	 * @return
	 */
	public static synchronized DbMgr getInstance() {
		//_logger.trace("Entering function");
		if (_instance == null) {
			_instance = new DbMgr();
		}
		return _instance; 
	}
	/**
	 * create SessionFactory
	 * @return
	 */
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	/**
	 * <---------------------------------------------------------EDSUser Table Operations------------------------------------------------------------------->
	 * @throws Exception 
	 */


	public String addEDSUser(Student user) throws Exception  {
//		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String id = null;
		try {
			id = (String) session.save(user);
			//_logger.debug("Session returned: "+id);
			session.flush();
			tx.commit();

		} catch (Exception e) {
			throw e;
			
		} finally {
			session.close();
		}
		//_logger.trace("Exiting method");	
		return id;
	}

	@SuppressWarnings("unchecked")
	public Vector<Student> getAllEDSUsers()  {
		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Vector<Student> users=new Vector<Student>();	
		List<Student> userList = null;
		try {
			userList = session.createSQLQuery("select * from edsuser_table").addEntity(Student.class).list();
			//_logger.debug("Number of EDSUserObject found:"+ userList);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			//_logger.error("Problem fetching EDSUserList: "+e, e);
			
		} finally {
			session.close();
		}

		
		if(userList.size()>0){
			users.addAll(userList);
		}

		//_logger.trace("Exiting method");
		return users;

	}


	public Student getEDSUserByEmail(String email)  {

		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Student userObject = null;
		try {
			userObject = (Student) session.createSQLQuery("select * from edsuser_table  where email=:email").addEntity(Student.class).setString("email", email).uniqueResult();
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			//_logger.error("Problem fetching EDSUserObject: "+e, e);
		} finally {
			session.close();
		}

		//_logger.trace("Exiting method");
		return userObject;

	}

	public Student getStudentByUID(String uid)  {

		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Student userObject = null;
		try {
			userObject = (Student) session.createSQLQuery("select * from edsuser_table  where uid=:uid").addEntity(Student.class).setString("uid", uid).uniqueResult();
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			//_logger.error("Problem fetching EDSUserObject: "+e, e);
		} finally {
			session.close();
		}

		//_logger.trace("Exiting method");
		return userObject;

	}
	
	public Student getStudentByActivationCode(String activationCode)  {

		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Student userObject = null;
		try {
			userObject = (Student) session.createSQLQuery("select * from edsuser_table  where activationCode=:activationCode").addEntity(Student.class).setString("activationCode", activationCode).uniqueResult();
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			//_logger.error("Problem fetching EDSUserObject: "+e, e);
		} finally {
			session.close();
		}

		//_logger.trace("Exiting method");
		return userObject;

	}

	public void removeEDSUser(Student user) {

		//_logger.trace("Entering method");
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.delete(user);
			session.flush();
			tx.commit();
		} catch(Exception e) {
			//_logger.error("Problem removing EDSUser: "+e, e);
			
		} finally {
			session.close();
		}

		//_logger.trace("Exiting method");
	}


	public void updateEDSUser(Student user)  {
		//_logger.trace("Entering method");
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.update(user);
			session.flush();
			tx.commit();
		} catch(Exception e) {
			//_logger.error("Problem updating EDSUser: "+e, e);
			
		} finally {
			session.close();
		}

		//_logger.trace("Exiting method");




	}
	
}
