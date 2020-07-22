/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Customer;
import com.eventorg.pojo.EventOrder;
import com.eventorg.pojo.Food;
import com.eventorg.pojo.Owner;
import com.eventorg.pojo.Venue;
import com.eventorg.pojo.Worker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aishw
 */
public class EventOrderDAO extends DAO {
    public EventOrder addEventorder(String eventname, Date dateofevent,double discount, double calculate, Date dateofreg, String status, Customer customer, Venue venue, Set<Worker> workers, Set<Food> foods){//, String type) {
        //int result = 0;
        EventOrder eventorder = null;
        try {
            beginTransaction();
            eventorder = new EventOrder();
            eventorder.setEventname(eventname);
            eventorder.setDateofevent(dateofevent);
            eventorder.setDiscount(discount);
            eventorder.setDateofreg(dateofreg);
            eventorder.setStatus(status);
            eventorder.setCustomer(customer);
            eventorder.setVenue(venue);
            eventorder.setWorkers(workers);
            eventorder.setFoods(foods);
            eventorder.setCalculatedsum(calculate);
//            customer.setType(type);
            
            getSession().save(eventorder);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return eventorder;
        }
    
    public int updateEventOrder(EventOrder eventOrder){
    int result = 0;
    try{
        beginTransaction();
//        Query q = getSession().createQuery("from Food where id= :id");
//        q.setLong("id", id);
//        Food m = (Food) q.uniqueResult();
//        m.setFoodname(foodname);
//        m.setFoodtype(foodtype);
//        m.setServecapacity(serveCapacity);
//        m.setPrice(price);
//        m.setOwners(owners);
        getSession().update(eventOrder);
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
    
    public List<EventOrder> getAllEventOrders(){
            List<EventOrder> eventOrders = null;
            try {
            beginTransaction();
            Query q = getSession().createQuery("from EventOrder");
            eventOrders = q.list();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return eventOrders;
        }
    
        public List<EventOrder> getEventOrdersById(long cid){
            List<EventOrder> eventOrders = null;
            try {
            beginTransaction();
            Query q = getSession().createQuery("from EventOrder where cid= :cid");
            q.setLong("cid", cid);
            eventOrders = q.list();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return eventOrders;
        }
        
        public List<EventOrder> getEventOrdersByStatus(String status, Venue venue){
            List<EventOrder> eventOrder = null;
            try {
            beginTransaction();
            eventOrder = new ArrayList();
            Query q = getSession().createQuery("from EventOrder where status= :status and venue= :venue");
            q.setString("status", status);
            q.setEntity("venue", venue);
            eventOrder = q.list();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return eventOrder;
        }
        
        public List<EventOrder> getEventOrdersVen(Venue venue){
            List<EventOrder> eventOrders = null;
            try {
            beginTransaction();
            eventOrders = new ArrayList();
            Query q = getSession().createQuery("from EventOrder where venue= :venue");
            q.setEntity("venue", venue);
            eventOrders = q.list();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return eventOrders;
        }
        
        public EventOrder getEventOrderById(long eid){
            EventOrder eventOrder = null;
            try {
            beginTransaction();
            Query q = getSession().createQuery("from EventOrder where eid= :eid");
            q.setLong("eid", eid);
            eventOrder = (EventOrder)q.uniqueResult();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return eventOrder;
        }
        public int deleteOrderById(long eid) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from EventOrder where eid= :eid");
            q.setLong("eid", eid);
            EventOrder orderToDelete = (EventOrder)q.uniqueResult();
            getSession().delete(orderToDelete);
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
}
