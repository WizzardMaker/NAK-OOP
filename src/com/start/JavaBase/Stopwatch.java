package com.start.JavaBase;

public class Stopwatch {
    long msStarted;
    long msElapsed;

    public Stopwatch(){
        msStarted = 0;
        msElapsed = 0;
    }

    public long getMsElapsed() {
        return msElapsed;
    }

    public void restart(){
        msStarted = System.currentTimeMillis();
        msElapsed = 0;
    }

    public void start(){
        msStarted = System.currentTimeMillis();
    }

    public void stop(){
        msElapsed += System.currentTimeMillis() - msStarted;
    }
}
