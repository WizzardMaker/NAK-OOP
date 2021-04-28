package com.start.JavaBase;

public class Stopwatch {
    long nsStarted;
    long nsElapsed;



    public Stopwatch(){
        nsStarted = 0;
        nsElapsed = 0;
    }

    public float getMsElapsed() {
        return nsElapsed / 1000000f;
    }

    public void restart(){
        nsStarted = System.nanoTime();
        nsElapsed = 0;
    }

    public void start(){
        nsStarted = System.nanoTime();
    }

    public void stop(){
        nsElapsed += System.nanoTime() - nsStarted;
    }
}
