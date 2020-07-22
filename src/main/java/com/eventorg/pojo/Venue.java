/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aishw
 */
public class Venue {
    private long oid;
    String placename;
//    String location;
    int capacity;
    double price;
    boolean isavailable;
    boolean isnegotiable;
//    int rating;
    Owner owner;
    Location location;
    Set<Date> venueassignment = new TreeSet();
    Set<EventOrder> eventorders = new HashSet();

    public Venue() {
    }

    public Venue(String placename, Location location, int capacity, double price, boolean isavailable, boolean isnegotiable, Owner owner) {
        this.placename = placename;
        this.location = location;
        this.capacity = capacity;
        this.price = price;
        this.isavailable = isavailable;
        this.isnegotiable = isnegotiable;
        this.owner = owner;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    
//   public long getVid() {
//        return vid;
//    }
//
//    public void setVid(long vid) {
//        this.vid = vid;
//    }

    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
  
//    public long getOid() {
//        return oid;
//    }
//
//    public void setOid(long oid) {
//        this.oid = oid;
//    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
               
    }

    public Boolean isIsavailable() {
        return isavailable;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }  

    public boolean isIsnegotiable() {
        return isnegotiable;
    }

    public void setIsnegotiable(boolean isnegotiable) {
        this.isnegotiable = isnegotiable;
    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
    
    
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Date> getVenueassignment() {
        return this.venueassignment;
    }

    public void setVenueassignment(Set<Date> venueassignment) {
        this.venueassignment = venueassignment;
    }

    public Set<EventOrder> getEventorders() {
        return eventorders;
    }

    public void setEventorders(Set<EventOrder> eventorders) {
        this.eventorders = eventorders;
    }
    
    public void addEventorder(EventOrder eventorder){
        eventorders.add(eventorder);
    }
    
    public void addVenueAssignment(Date date){
        venueassignment.add(date);
    }
    
     public void deleteEventOrder(EventOrder eventorder){
        this.eventorders.remove(eventorder);
    }   
}
