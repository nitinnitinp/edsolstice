package com.edsolstice.educationportal.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseTransation <T>  extends DBSession {

    Class<T> cls ;

    public DatabaseTransation (Class<T> cls) {
        this.cls=cls;
    }

    /**
     * <---------------------------------------------------------Table Operations------------------------------------------------------------------->
     * @throws Exception 
     */


    public String save(T dto) throws Exception  {
        //		//_logger.trace("Entering method");

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String id = null;
        try {
            id = (String) session.save(dto);
            //_logger.debug("Session returned: "+id);
            session.flush();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        //_logger.trace("Exiting method");	
        return id;
    }

    public List<String> save(T ... dtos) throws Exception  {
        //      //_logger.trace("Entering method");
        List <String> ids = new ArrayList<String>();
        for (T dto : dtos) {
            String id =save(dto) ;
            ids.add(id);
        }
        //_logger.trace("Exiting method");  
        return ids;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll()  {
        //_logger.trace("Entering method");

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();	
        List<T> dtos = null;
        try {

            dtos = session.createSQLQuery("select * from "+cls.getSimpleName().toLowerCase()).addEntity(cls).list();
            //_logger.debug("Number of EDSUserObject found:"+ userList);
            session.flush();
            tx.commit();
        } catch (HibernateException e) {
            throw e;

        } finally {
            session.close();
        }

        //_logger.trace("Exiting method");
        return dtos;

    }

    public T get(String uid)  {
        T t = get("uid" , uid) ;
        return t;
    }

    public T get(String queryName , String queryValue)  {

        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        T dto = null;
        try {
            dto = (T) session.createSQLQuery("select * from "+cls.getSimpleName().toLowerCase()+" where "+queryName+"=:"+queryName).addEntity(cls).setString(queryName, queryValue).uniqueResult();
            session.flush();
            tx.commit();
        } catch (HibernateException e) {

        } finally {
            session.close();
        }
        return dto;

    }


    public void update(T dto) throws Exception {


        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.update(dto);
            session.flush();
            tx.commit();
        } catch(Exception e) {
            throw e;

        } finally {
            session.close();
        }

    }


    public void update(T ... dtos) throws Exception  {
        //      //_logger.trace("Entering method");

        for (T dto : dtos) {
            update(dto);
        }
        //_logger.trace("Exiting method");  

    }


    public void delete(T dto) throws Exception  {
        //_logger.trace("Entering method");
        Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.delete(dto);
            session.flush();
            tx.commit();
        } catch(Exception e) {
            throw e;

        } finally {
            session.close();
        }


    }


    public void delete(T ... dtos) throws Exception  {
        //      //_logger.trace("Entering method");

        for (T dto : dtos) {
            delete(dto);
        }
        //_logger.trace("Exiting method");  

    }


}
