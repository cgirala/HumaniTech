package com.example.meganyang.humanitech.Model;

/**
 * Created by Christian Girala on 4/2/2016.
 */
public class Alarm {
    private String name;
    private boolean isOn;
    private int minute;
    private int hour;
    private boolean[] days = new boolean[7];

    public Alarm (String name, boolean isOn, int hour, int minute) {
        this.name = name;
        this.isOn = isOn;
        this.hour = hour;
        this.minute = minute;
    }

    public String getName() {
        return name;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }


    public void setIsOn(boolean isOn) {

    }
    public void setName(String name) {

    }


}
