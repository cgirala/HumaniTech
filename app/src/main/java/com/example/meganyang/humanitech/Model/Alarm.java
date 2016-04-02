package com.example.meganyang.humanitech.Model;

/**
 * Created by Christian Girala on 4/2/2016.
 */
public class Alarm {
    private String name;
    private boolean isOn;
    private long time;
    private boolean[] days = new boolean[7];

    public Alarm (String name, boolean isOn, long time) {
        this.name = name;
        this.isOn = isOn;
        this.time = time;
    }

    public void setIsOn(boolean isOn) {

    }
    public void setName(String name) {

    }


}
