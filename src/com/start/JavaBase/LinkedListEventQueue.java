package com.start.JavaBase;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListEventQueue<E> implements IEventQueue<E>{
    private LinkedList<IEntry<E>> list;

    public LinkedListEventQueue(){
        list = new LinkedList<IEntry<E>>();
    }

    @Override
    public void enqueue(double time, E e){
        IEntry<E> entry = new Entry(e, time);

        if(list.size() != 0){
            int it = 0;
            Iterator<IEntry<E>>  itr = list.iterator();
            while (itr.hasNext()) {
                if(itr.next().getTime() > time){
                    list.add(it,entry);
                    return;
                }
                it++;
            }
        }

        list.add(entry);
    }

    @Override
    public IEntry<E> dequeue(){
        IEntry<E> e = list.get(0);
        list.remove(0);
        return e;
    }

    public class Entry<E> implements IEntry<E> {
        double time;
        E event;

        @Override
        public double getTime() {
            return time;
        }

        @Override
        public E getEvent() {
            return event;
        }

        public Entry(E event, double time){
            this.event = event;
            this.time = time;
        }
    }
}
