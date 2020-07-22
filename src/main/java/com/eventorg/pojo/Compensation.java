/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.pojo;

import java.util.Date;

/**
 *
 * @author aishw
 */
public class Compensation {
    long coid;
    String eventname;
    Date eventdate;
    String eventstatus;
    int extrahours;
    Date dateofrequest;
    String compensationstatus;
    Worker worker;

    public Compensation() {
    }

    public long getCoid() {
        return coid;
    }

    public void setCoid(long coid) {
        this.coid = coid;
    }

    public int getExtrahours() {
        return extrahours;
    }

    public void setExtrahours(int extrahours) {
        this.extrahours = extrahours;
    }

    public Date getDateofrequest() {
        return dateofrequest;
    }

    public void setDateofrequest(Date dateofrequest) {
        this.dateofrequest = dateofrequest;
    }

    public String getCompensationstatus() {
        return compensationstatus;
    }

    public void setCompensationstatus(String compensationstatus) {
        this.compensationstatus = compensationstatus;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventstatus() {
        return eventstatus;
    }

    public void setEventstatus(String eventstatus) {
        this.eventstatus = eventstatus;
    }
    
}
