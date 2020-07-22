/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Location;
import com.eventorg.pojo.Owner;
import com.eventorg.pojo.Venue;
import java.util.ArrayList;
//import com.mysql.cj.Query;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aishw
 */
public class VenueDAO extends DAO{
        public Venue addVenue(String placename, Location location, int capacity, double price, boolean isavailable, boolean isnegotiable, Owner owner) {
        //int result = 0;
        Venue venue = null;
        try {
            beginTransaction();
            venue = new Venue();//placename, location, capacity, price, isavailable, isnegotiable, owner);
            venue.setPlacename(placename);
            venue.setLocation(location);
            venue.setCapacity(capacity);
            venue.setPrice(price);
            venue.setIsavailable(isavailable);
            venue.setIsnegotiable(isnegotiable);
            venue.setOwner(owner);
            //venue.setOid(owner.getOid());
            getSession().save(venue);
            commit();
            //result = 1;
            return venue;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return venue;
        }
    
        public int addVenue(Venue venue) {
        int result = 0;
        try {
            getSession().beginTransaction();
            getSession().save(venue);
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
        
        public List<Venue> getVenue(Owner owner){//, String placename, Location location, int capacity, double price, boolean isavailable, boolean isnegotiable){
        //int result = 0;
        List<Venue> venues = null;
        try{
            beginTransaction();
            //m = new Venue();
            venues = new ArrayList();
            Query q = getSession().createQuery("from Venue where owner= :owner");
            q.setEntity("owner", owner);
            venues = q.list();
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
        return venues;
        }
        
        public int updateVenue(long oid, String placename, int capacity, double price, boolean isavailable, boolean isnegotiable){
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Venue where oid= :oid");
            q.setLong("oid", oid);
            Venue m = (Venue) q.uniqueResult();
            m.setPlacename(placename);
            //m.setLocation(location);
            m.setCapacity(capacity);
            m.setPrice(price);
            m.isIsavailable();
            m.isIsnegotiable();
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
        
        public int updateVenue(Venue venue){
        int result = 0;
        try{
            beginTransaction();
           // Query q = getSession().createQuery("from Venue where oid= :oid");
//            q.setLong("oid", oid);
//            Venue m = (Venue) q.uniqueResult();
//            m.setPlacename(placename);
//            //m.setLocation(location);
//            m.setCapacity(capacity);
//            m.setPrice(price);
//            m.isIsavailable();
//            m.isIsnegotiable();
            getSession().update(venue);
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
    
        
        public int deleteVenueById(long oid) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Venue where oid= :oid");
            q.setLong("oid", oid);
            Venue venueToDelete = (Venue)q.uniqueResult();
            getSession().delete(venueToDelete);
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
        
        public int deleteVenueByOwner(Owner owner) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Venue where Owner= :owner");
            q.setEntity("owner", owner);
            Venue venueToDelete = (Venue)q.uniqueResult();
            getSession().delete(venueToDelete);
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
    
        public List<Venue> getVenuesByLocation(Location location){
            List<Venue> venues = null;
            try {
            beginTransaction();
            Query q = getSession().createQuery("from Venue where Location= :location");
            q.setEntity("location", location);
            venues = q.list();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return venues;
        }
        
        public List<Venue> getAllVenues(){
            List<Venue> venues = null;
            try {
            beginTransaction();
            Query q = getSession().createQuery("from Venue");
            venues = q.list();
            //getSession().delete(venueToDelete);
            commit();
            //result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return venues;
        }
}
