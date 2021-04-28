package com.start.JavaBase;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        int n = 5000000, m = 5;

        //Create all events
        //IEventQueue<Event> queue = new LinkedListEventQueue<>();
        Experiment[] experiments = new Experiment[2];
        experiments[1] = new Experiment("ArrayList", new ArrayListEventQueue<>());
        experiments[0] = new Experiment("LinkedList", new LinkedListEventQueue<>());

        for(int i = 0; i < experiments.length; i++){
            experiments[i].initialize(n);
            experiments[i].evaluate(m);
        }

    }
}
