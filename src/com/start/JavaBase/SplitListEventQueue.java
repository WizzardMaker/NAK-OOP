package com.start.JavaBase;

import java.util.*;

public class SplitListEventQueue<E> implements IEventQueue<E> {
    static int MAX_NEAR_SIZE = 1000;
    PriorityQueue<Entry> near;
    int elementsInNear;
    double oldestElement;

    boolean isDirty = false;
    ArrayList<Entry<E>> far;

    public SplitListEventQueue(){
        near = new PriorityQueue<Entry>(MAX_NEAR_SIZE,new ComparatorSplitList());
        far = new ArrayList<Entry<E>>();
    }

    @Override
    public void enqueue(double time, E event) {
        Entry<E> e = new Entry<E>(event, time);

        if(time >= oldestElement && elementsInNear >= MAX_NEAR_SIZE){
            //add to far -
            far.add(e);
            isDirty = true;
        }else{
            addToQueue(e);
        }
    }

    private void addToQueue(Entry<E> e) {
        near.add(e);
        if(e.getTime() >= oldestElement){
            oldestElement = e.getTime();
        }
        elementsInNear++;

        if(elementsInNear > MAX_NEAR_SIZE){
            //Remove last element
            int counter = 0;
            double secOldest = 0;
            Iterator<Entry> it = near.iterator();
            while (it.hasNext()) {
                Entry<E> find = it.next();
                counter++;
                if (counter == near.size()) {
                    near.remove(find);
                    far.add(e);
                    isDirty = true;
                    break;
                }
                secOldest = find.getTime();
            }
            oldestElement = secOldest;
            elementsInNear--;
        }
    }

    int partition(Entry<E>[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i].getTime() < array[pivot].getTime()) {
                Entry<E> temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        Entry<E> temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    void quickSort(Entry<E>[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    @Override
    public IEntry<E> dequeue() {
        Entry<E> e = near.poll();
        elementsInNear--;

        if(elementsInNear <= 0){
            if(isDirty) {
                Entry<E>[] buffer = new Entry[far.size()];
                buffer = far.toArray(buffer);
                quickSort(buffer, 0, far.size()-1);
                far = new ArrayList<Entry<E>>(Arrays.asList(buffer));
            }

            for(int i = 0; i < MAX_NEAR_SIZE; i++){
                if(far.size() <= i) {
                    break;
                }
                var n = far.get(i);
                near.add(n);
                oldestElement = n.getTime();
            }
            for(int i = 0; i < MAX_NEAR_SIZE; i++) {
                if(far.size() < 1)
                    break;

                far.remove(0);
            }
            isDirty = false;
            elementsInNear = MAX_NEAR_SIZE;
        }

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
