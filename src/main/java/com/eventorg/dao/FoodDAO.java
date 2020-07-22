/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.dao;

import com.eventorg.pojo.Food;
import com.eventorg.pojo.Owner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author aishw
 */
public class FoodDAO extends DAO{
    public int addFood(String foodname, String foodtype, int servecapacity, double price, Set<Owner> owners) {
        int result = 0;
        try {
            beginTransaction();
            Food food = new Food();
            food.setFoodname(foodname);
            food.setFoodtype(foodtype);
            food.setServecapacity(servecapacity);
            food.setPrice(price);
            food.setOwners(owners);
                   
            getSession().save(food);
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
    
    public int addFood(String foodname, String foodtype, int servecapacity, double price) {
        int result = 0;
        try {
            beginTransaction();
            Food food = new Food();
            food.setFoodname(foodname);
            food.setFoodtype(foodtype);
            food.setServecapacity(servecapacity);
            food.setPrice(price);
            //food.setOwners(owners);
                   
            getSession().save(food);
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
    
    public List<Food> getFoods() {
        List<Food> foo = new ArrayList();
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Food");

            foo = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return foo;
    }
    
    public Food getFood(long oid) {
        Food foo = null;
        try {
            beginTransaction();
            foo = new Food();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Food where oid= :oid");
            q.setLong("oid", oid);
            foo = (Food)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return foo;
    }
    
    public int updateFood(Food food){
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
        getSession().update(food);
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
    
    public List<Food> getFoods(String foodtype) {
        List<Food> foo = new ArrayList();
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Food where foodtype= :foodtype");

            foo = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return foo;
    }
}
