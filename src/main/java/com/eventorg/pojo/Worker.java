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
public class Worker {
    private long oid;

//    private int wid;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String phonenumber;
    private String email;
    private String photopath;
    private boolean isavailable;  
//    private String type;
    Owner owner;
    
    Set<Date> workerassignment = new HashSet();
    Set<EventOrder> eventorders = new HashSet();
    Set<Compensation> compensations = new HashSet();

    public Worker() {
    }

    public Worker(long oid, String firstname, String lastname, String password, String address, String phonenumber, String email, boolean isavailable) {
        this.oid = oid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.isavailable = isavailable;
    }

    
    public Worker(String firstname, String lastname, String password, String address, String phonenumber, String email, String photopath, boolean isavailable, Owner owner) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.photopath = photopath;
        this.isavailable = isavailable;
        this.owner = owner;
    }

//    public int getWid() {
//        return wid;
//    }
//
//    public void setWid(int wid) {
//        this.wid = wid;
//    }

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

    public boolean isIsavailable() {
        return isavailable;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
    public void setIsavailable(boolean isavailable) {    
        this.isavailable = isavailable;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Date> getWorkerassignment() {
        return workerassignment;
    }

    public void setWorkerassignment(Set<Date> workerassignment) {
        this.workerassignment = workerassignment;
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
    
    public void addWorkerAssignment(Date date){
        workerassignment.add(date);
    }
    
     public void deleteEventOrder(EventOrder eventorder){
        this.eventorders.remove(eventorder);
    }   

    public Set<Compensation> getCompensations() {
        return compensations;
    }

    public void setCompensations(Set<Compensation> compensations) {
        this.compensations = compensations;
    }
     
    public void addCompensation(Compensation compensation){
        this.compensations.add(compensation);
    }
    
    public void delCompensation(Compensation compensation){
        this.compensations.remove(compensation);
    }
}
