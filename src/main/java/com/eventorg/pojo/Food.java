/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aishw
 */
public class Food {
    private long oid;
    
//    private int fid;
    private String foodname;
    private String foodtype;
    private int servecapacity;
    private double price;
    private Set<Owner> owners = new HashSet<Owner>();
    private Set<EventOrder> eventorders = new HashSet();

    public Food() {
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public int getServecapacity() {
        return servecapacity;
    }

    public void setServecapacity(int servecapacity) {
        this.servecapacity = servecapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
    
    public void addOwner(Owner owner){
        owners.add(owner);
    }

    public Set<EventOrder> getEventorders() {
        return eventorders;
    }

    public void setEventorders(Set<EventOrder> eventorders) {
        this.eventorders = eventorders;
    }
    
    public void addEventOrder(EventOrder eventorder){
        this.eventorders.add(eventorder);
    }
    
    public void deleteEventOrder(EventOrder eventorder){
        this.eventorders.remove(eventorder);
    }   
    
    public void delOwner(Owner owner){
        eventorders.remove(owner);
    }
}
