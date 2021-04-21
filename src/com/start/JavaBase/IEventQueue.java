package com.start.JavaBase;

public interface IEventQueue<E> {

    void enqueue (double time, E event);

    IEventQueue.IEntry<E> dequeue ();

    public interface IEntry<E> {

        double getTime();

        E getEvent();

    }
}
