package com.start.JavaBase;

public class SortedArrayEventQueue<E> extends BaseArrayEventQueue<E>{

    public SortedArrayEventQueue() {
        super();
    }

    @Override
    public void enqueue(double time, E event) {
        //check if Array has enough space for new Event
        resizeWhenNeeded();

        boolean addedItem = false;
        Entry newEntry = new Entry(event, time);
        if(items == 0){
            list[0] = newEntry;
        }else {
            for (int i = 0; i < items; i++) {
                if (newEntry.getTime() < list[i].getTime()) {
                    addElementAt(i, newEntry);
                    addedItem = true;
                    break;
                }
            }

            if(!addedItem){
                list[items] = newEntry;
            }
        }

        items++;
    }

    @Override
    public IEntry<E> dequeue() {
        if(items == 0)
            return null;

        Entry first = list[0];
        removeElementAt(0);

        resizeWhenNeeded();
        items--;
        return first;
    }
}
