/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Customer;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aishw
 */
public class CustomerDAO extends DAO{
    public int addCustomer(String firstname, String lastname, String password, String address, String phonenumber, String email, String photopath){//, String type) {
        int result = 0;
        try {
            beginTransaction();
            Customer customer = new Customer();//firstname, lastname, password, address, phonenumber, email, photopath);
            customer.setFirstname(firstname);
            customer.setLastname(lastname);
            customer.setPassword(password);
            customer.setAddress(address);
            customer.setPhonenumber(phonenumber);
            customer.setEmail(email);
            customer.setPhotopath(photopath);
//            customer.setType(type);
            
            getSession().save(customer);
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
    
        public Customer getCustomer(String email,String password) {
        Customer u = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Customer where email= :email and password= :password");
            q.setString("email", email);
            q.setString("password", password);
            u = (Customer)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return u;
    }
        
        public List<Customer> getAllCusts() {
        List<Customer> custList = null;
        try {
            beginTransaction();
            custList = new ArrayList();
            Query q = getSession().createQuery("from Customer");
            custList = q.list();
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
        return custList;
    }
}
