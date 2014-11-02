package com.edsolstice.educationportal.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DBSession {
	SessionFactory sessionFactory;
	public  DBSession () {

		sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				buildSessionFactory();
	}

	/**
	 * create SessionFactory
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
