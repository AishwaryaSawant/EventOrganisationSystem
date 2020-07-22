/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Location;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aishw
 */
public class LocationDAO extends DAO{
    public int addLocation(String loc){//, String lastName, String password, String address, String phoneNumber, String email, String photopath){//, String type) {
        int result = 0;
        try {
            beginTransaction();
            Location l = new Location();//firstName, lastName, password, address, phoneNumber, email);
            
            l.setName(loc);
//            u.setType(type);
//            u.setVenues(venueSet);
//            u.setFoods(foodSet);
//            u.setWorkers(workerSet);
//            
            getSession().save(l);
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
    
    public List<Location> getLocations() {
        List<Location> loc = new ArrayList();
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Location");

            loc = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return loc;
    }
    
    public Location getLocation(long id) {
        Location location = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Location where id= :id");
            q.setLong("id", id);
            location = (Location)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return location;
    }
}
