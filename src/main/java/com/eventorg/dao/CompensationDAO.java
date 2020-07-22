/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Compensation;
import org.hibernate.HibernateException;

/**
 *
 * @author aishw
 */
public class CompensationDAO extends DAO{
//    public Compensation addCompensation(String placename, Location location, int capacity, double price, boolean isavailable, boolean isnegotiable, Owner owner) {
//        //int result = 0;
//        Venue venue = null;
//        try {
//            beginTransaction();
//            venue = new Venue();//placename, location, capacity, price, isavailable, isnegotiable, owner);
//            venue.setPlacename(placename);
//            venue.setLocation(location);
//            venue.setCapacity(capacity);
//            venue.setPrice(price);
//            venue.setIsavailable(isavailable);
//            venue.setIsnegotiable(isnegotiable);
//            venue.setOwner(owner);
//            //venue.setOid(owner.getOid());
//            getSession().save(venue);
//            commit();
//            //result = 1;
//            return venue;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            rollbackTransaction();
//        } finally {
//            close();
//        }
//        return venue;
//        }
    
        public int addCompensation(Compensation compensation) {
        int result = 0;
        try {
            getSession().beginTransaction();
            getSession().save(compensation);
            getSession().getTransaction().commit();
             result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }
        return result;
    }
}
