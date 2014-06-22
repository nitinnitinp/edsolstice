package com.edsolstice.educationportal.dbmodel;

import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EDSDbMgr {

	private SessionFactory sessionFactory;
	private static EDSDbMgr _instance ; 

	private EDSDbMgr() {
		
        sessionFactory =  new Configuration().
        		configure("hibernate.cfg.xml").buildSessionFactory();

	}
	

	
	/**
	 * 
	 * @return
	 */
	public static synchronized EDSDbMgr getInstance() {
		//_logger.trace("Entering function");
		if (_instance == null) {
			_instance = new EDSDbMgr();
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
	 */


	public long addEDSUser(EDSUser user)  {
//		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		long id = -1;
		try {
			id = (Long) session.save(user);
			//_logger.debug("Session returned: "+id);
			session.flush();
			tx.commit();

		} catch (Exception e) {
			//_logger.error("Problem saving EDSUserObject: "+e, e);
			
		} finally {
			session.close();
		}
		//_logger.trace("Exiting method");	
		return id;
	}

	@SuppressWarnings("unchecked")
	public Vector<EDSUser> getAllEDSUsers()  {
		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Vector<EDSUser> users=new Vector<EDSUser>();	
		List<EDSUser> userList = null;
		try {
			userList = session.createSQLQuery("select * from edsuser_table").addEntity(EDSUser.class).list();
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


	public EDSUser getEDSUserForLogicalName(String email)  {

		//_logger.trace("Entering method");

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		EDSUser userObject = null;
		try {
			userObject = (EDSUser) session.createSQLQuery("select * from edsuser_table  where emaid=:email").addEntity(EDSUser.class).setString("email", email).uniqueResult();
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


	public void removeEDSUser(EDSUser user) {

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


	public void updateEDSUser(EDSUser user)  {
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
