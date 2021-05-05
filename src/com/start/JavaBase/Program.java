package com.start.JavaBase;

public class Program {
    public static void main(String[] args) {
        int n = 100000, m = 3;

        //Create all events
        //IEventQueue<Event> queue = new LinkedListEventQueue<>();
        Experiment[] experiments = new Experiment[2];
        experiments[0] = new Experiment("UnsortedArrayEventQueue", new UnsortedArrayEventQueue<Event>());
        experiments[1] = new Experiment("SortedArrayEventQueue", new SortedArrayEventQueue<Event>());

        for(int i = 0; i < experiments.length; i++){
            experiments[i].initialize(n);
            experiments[i].evaluate(5);
        }

        experiments[0] = new Experiment("UnsortedArrayEventQueue", new UnsortedArrayEventQueue<Event>());
        experiments[1] = new Experiment("SortedArrayEventQueue", new SortedArrayEventQueue<Event>());

        for(int i = 0; i < experiments.length; i++){
            experiments[i].initialize(n);
            experiments[i].evaluate(m);
        }

    }
}
