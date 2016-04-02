package com.example.meganyang.humanitech.Model;

import java.util.ArrayList;

/**
 * Created by Christian Girala on 4/2/2016.
 */
public class Alarm {
    private boolean[] days;
    private boolean isOn;
    private String name;
    private long time;

    public Alarm (String name, boolean isOn, long time, boolean[] days) {
        this.name = name;
        this.isOn = isOn;
        this.time = time;
        this.days = days;
    }

    public void setDays(boolean[] days) {
        this.days = days;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(long time) {
        this.name = name;
    }

    public boolean[] getDays() {
        return days;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public ArrayList toArraylist() {
        ArrayList transform = new ArrayList();
        transform.add(days);
        transform.add(isOn);
        transform.add(name);
        transform.add(time);
        return transform;
    }

}
