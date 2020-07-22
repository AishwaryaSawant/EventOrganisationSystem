/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.pojo;

import java.util.Set;

/**
 *
 * @author aishw
 */
public class Location {
    long lid;
    String name;
    private Set<Venue> lvenues;

    public Location() {
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Venue> getLvenues() {
        return lvenues;
    }

    public void setLvenues(Set<Venue> lvenues) {
        this.lvenues = lvenues;
    }

}
