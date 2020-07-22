/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Owner;
import com.eventorg.pojo.Worker;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aishw
 */
public class WorkerDAO extends DAO{
    public Worker addWorker(String firstname, String lastname, String password, String address, String phonenumber, String email, String photoPath, boolean isavailable, Owner owner){//, String type) {
        //int result = 0;
        Worker worker = null;
        try {
            beginTransaction();
            worker = new Worker();//firstname, lastname, password, address, phonenumber, email, photopath, isavailable, owner);
            worker.setFirstname(firstname);
            worker.setLastname(lastname);
            worker.setPassword(password);
            worker.setAddress(address);
            worker.setPhonenumber(phonenumber);
            worker.setEmail(email);
            worker.setPhotopath(photoPath);
            worker.setIsavailable(isavailable);
            worker.setOwner(owner);
//            worker.setType(type);
            
            getSession().save(worker);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return worker;
        }
    
        public Worker getWorker(String email,String password) {
        Worker u = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Worker where email= :email and password= :password");
            q.setString("email", email);
            q.setString("password", password);
            u = (Worker)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return u;
    }
        
        public List<Worker> getAllWorkers() {
        List<Worker> workers = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Worker");
            workers = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return workers;
    }
        
        public Worker getWorker(long oid) {
        Worker u = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Worker where oid= :oid");
            q.setLong("oid", oid);
            u = (Worker)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return u;
    }
         public int updateWorker(Worker worker){
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
        getSession().update(worker);
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
         
          public int deleteWorkerById(long oid) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Worker where oid= :oid");
            q.setLong("oid", oid);
            Worker workerToDelete = (Worker)q.uniqueResult();
            getSession().delete(workerToDelete);
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
          
        public int updateWorker(long oid, String firstname,String lastname, String email, String password, String address, String phno, boolean isavailable){//, boolean isnegotiable){
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Worker where oid= :oid");
            q.setLong("oid", oid);
            Worker m = (Worker) q.uniqueResult();
            m.setFirstname(firstname);
            m.setLastname(lastname);
            m.setEmail(email);
            m.setPassword(password);
            m.setAddress(address);
            m.setPhonenumber(phno);
            m.setIsavailable(isavailable);
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
}
