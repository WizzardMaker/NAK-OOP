package com.start.JavaBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.NoSuchElementException;

public abstract class BaseArrayEventQueue<E> implements IEventQueue<E>{
    Entry[] list;
    int items;

    final int stepSize = 100;


    public BaseArrayEventQueue() {
        list = new Entry[100];
    }

    @Override
    public abstract void enqueue(double time, E event);

    @Override
    public abstract IEntry<E> dequeue();

    /**
     * Checks whether the array is at it's limits [higher: (items+1 > length - stepSize) lower:(items <)] and resizes
     */
    public void resizeWhenNeeded(){
        Entry[] nList = list;

        if(items+1 > list.length - stepSize){
            nList = new Entry[list.length * 2];

            System.arraycopy(list, 0, nList,0, list.length);
        }else if(items < (list.length/2) - stepSize){
            nList = new Entry[list.length / 2];

            System.arraycopy(list, 0, nList,0, items);
        }

        list = nList;
    }

    public void addElementAt(int index, Entry element){
        System.arraycopy(list, index, list, index+1, items - index);

        list[index] = element;
    }

    public void removeElementAt(int index){
        System.arraycopy(list, index+1, list, index, list.length - index-1);
    }

    @Override
    public int getLength(){
        return items;
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
