/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.pojo;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.mapping.Map;

/**
 *
 * @author aishw
 */
public class Owner {
    private long oid;

    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String phonenumber;
    private String email;
    private String photopath;
    private Set<Venue> venues;
    private Set<Worker> workers;
    private Set<Food> foods = new HashSet<>();

    public Owner(){
        
    }
    
    public Owner(String firstname, String lastname, String password, String address, String phonenumber, String email, String photopath) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.photopath = photopath;
    }
    
    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public Set<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
    
    public void addFood(Food food){
        foods.add(food);
    }
    
    public void delFood(Food food){
        foods.remove(food);
    }

    public void deleteVenue(Venue venue){
        venues.remove(venue);
    }
    
    public void deleteWorker(Worker worker){
        workers.remove(worker);
    }
}
