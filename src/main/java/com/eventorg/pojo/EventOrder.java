/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aishw
 */
public class EventOrder {
    private long eid;
    String eventname;
    private double discount;
    private double calculatedsum;
    private Date dateofevent;
    private Date dateofreg;
    private String status;
    Customer customer = new Customer();
    Venue venue = new Venue();
    Set<Worker> workers = new HashSet();
    Set<Food> foods = new HashSet();

    public EventOrder() {
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getCalculatedsum() {
        return calculatedsum;
    }

    public void setCalculatedsum(double calculatedsum) {
        this.calculatedsum = calculatedsum;
    }

    public Date getDateofevent() {
        return dateofevent;
    }

    public void setDateofevent(Date dateofevent) {
        this.dateofevent = dateofevent;
    }

    public Date getDateofreg() {
        return dateofreg;
    }

    public void setDateofreg(Date dateofreg) {
        this.dateofreg = dateofreg;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
    
    public void addFood(Food food){
        foods.add(food);
    }
    
    public void addWorker(Worker worker){
        workers.add(worker);
    }
    
    public void delFood(Food food){
        foods.remove(food);
    }
    
    public void delWorker(Worker worker){
        workers.remove(worker);
    }
    

}
