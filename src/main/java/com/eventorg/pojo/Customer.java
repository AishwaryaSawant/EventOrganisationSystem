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
public class Customer {
    private long cid;

    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String phonenumber;
    private String email;
    private String photopath;
    
    Set<EventOrder> eventorders = new HashSet();
//    private String type;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String password, String address, String phonenumber, String email, String photopath) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.photopath = photopath;
        
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
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
    
    

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public Set<EventOrder> getEventorders() {
        return eventorders;
    }

    public void setEventorders(Set<EventOrder> eventorders) {
        this.eventorders = eventorders;
    }
  
    
}
