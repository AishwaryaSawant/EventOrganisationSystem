/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Food;
import com.eventorg.pojo.Owner;
import com.eventorg.pojo.Venue;
import com.eventorg.pojo.Worker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author aishw
 */
public class OwnerDAO extends DAO{

//    public OwnerDAO() {
//    }
   
    
    public int addOwner(String firstName, String lastName, String password, String address, String phoneNumber, String email, String photopath, Set<Venue> ven, Set<Worker> wor, Set<Food> foo){//, String type) {
        int result = 0;
        try {
            beginTransaction();
            Owner u = new Owner();//firstName, lastName, password, address, phoneNumber, email);
            
            u.setFirstname(firstName);
            u.setLastname(lastName);
            u.setPassword(password);
            u.setAddress(address);
            u.setPhonenumber(phoneNumber);
            u.setEmail(email);
            u.setPhotopath(photopath);
            u.setVenues(ven);
            u.setWorkers(wor);
            u.setFoods(foo);
//            u.setType(type);
//            u.setVenues(venueSet);
//            u.setFoods(foodSet);
//            u.setWorkers(workerSet);
//            
            getSession().save(u);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
        }
    
    public Owner getOwner(String email,String password) {
        Owner u = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Owner where email= :email and password= :password");
            q.setString("email", email);
            q.setString("password", password);

            u = (Owner)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return u;
    }
    
    public Owner getOwner(long oid) {
        Owner u = null;
        try {
            beginTransaction();
            u= new Owner();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Owner where oid= :oid");
            q.setLong("oid", oid);
            //q.setString("password", password);

            u = (Owner)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return u;
    }
    
    public int updateOwner(Owner owner){
    int result = 0;
    try{
        beginTransaction();
//        Query q = getSession().createQuery("from Owner where id= :id");
//        q.setLong("id", id);
//        Owner m = (Owner) q.uniqueResult();
//        m.setFirstname(firstname);
//        m.setLastname(lastname);
//        m.setPassword(password);
//        m.setAddress(address);
//        m.setEmail(email);
//        m.setPhotopath(photopath);
//        m.setFoods(foods);
        getSession().update(owner);
        commit();
        result = 1;
    } catch(HibernateException ex){
        ex.printStackTrace();
        rollbackTransaction();
    } finally{
        close();
    }
    return result;
    }
    
            public Venue getVenue(long oid){//, String placename, Location location, int capacity, double price, boolean isavailable, boolean isnegotiable){
        //int result = 0;
        Venue m = null;
        try{
            beginTransaction();
            //m = new Venue();
            Query q = getSession().createQuery("from Venue where oid= :oid");
            q.setLong("oid", oid);
            m = (Venue)q.uniqueResult();
//            m.setPlacename(placename);
//            m.setLocation(location);
//            m.setCapacity(capacity);
//            m.setPrice(price);
//            m.isIsavailable();
//            m.isIsnegotiable();
            //getSession().save(m);
            commit();
            //return m;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return m;
        }
        
        public int updateOwner(long oid, String firstname, String lastname, String password, String address, String phonenumber, String email){
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Owner where oid= :oid");
            q.setLong("oid", oid);
            Owner m = (Owner) q.uniqueResult();
            m.setFirstname(firstname);
            m.setLastname(lastname);
            m.setPassword(password);
            m.setAddress(address);
            m.setPhonenumber(phonenumber);
            m.setEmail(email);
//            m.setPlacename(placename);
//            //m.setLocation(location);
//            m.setCapacity(capacity);
//            m.setPrice(price);
//            m.isIsavailable();
//            m.isIsnegotiable();
            getSession().save(m);
            commit();
            result = 1;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return result;
        }
    
        
        public int deleteOwnerById(long oid) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Owner where oid= :oid");
            q.setLong("oid", oid);
            Owner ownerToDelete = (Owner)q.uniqueResult();
            getSession().delete(ownerToDelete);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
    }
        
        public List<Owner> getAllOwners() {
        List<Owner> ownerList = null;
        try {
            beginTransaction();
            ownerList = new ArrayList();
            Query q = getSession().createQuery("from Owner");
            ownerList = q.list();
            //Owner ownerToDelete = (Owner)q.uniqueResult();
//            getSession().delete(ownerToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return ownerList;
    }
  
        
    }
