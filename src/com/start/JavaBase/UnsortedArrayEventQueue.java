package com.start.JavaBase;

public class UnsortedArrayEventQueue<E> extends BaseArrayEventQueue<E>{

    public UnsortedArrayEventQueue() {
        super();
    }

    @Override
    public void enqueue(double time, E event) {
        //check if Array has enough space for new Event
        resizeWhenNeeded();

        list[items] = new Entry(event, time);

        items++;
    }

    @Override
    public IEntry<E> dequeue() {
        if(items == 0)
            return null;

        int smallestIndex = 0;
        Entry smallestEvent = list[0];
        for(int i = 1; i < items; i++){
           if (smallestEvent.getTime() > list[i].getTime()){
               smallestEvent = list[i];
               smallestIndex = i;
           }
        }
        removeElementAt(smallestIndex);

        resizeWhenNeeded();
        items--;
        return smallestEvent;
    }
}
