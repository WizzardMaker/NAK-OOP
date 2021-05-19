package com.start.JavaBase;

public interface IEventQueue<E> {

    void enqueue (double time, E event);

    IEventQueue.IEntry<E> dequeue ();

    int getLength();

    public interface IEntry<E> {
        double getTime();

        E getEvent();
    }
}
