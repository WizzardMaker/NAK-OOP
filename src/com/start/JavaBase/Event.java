package com.start.JavaBase;

import java.util.Random;

public class Event {
    private int value;


    public Event(){
    }

    static Event getRandomEvent(){
        return new Event();
    }
}
