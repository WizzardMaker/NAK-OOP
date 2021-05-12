package com.start.JavaBase;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int n = 200000, m = 3;

        System.out.printf("Running Experiment with %d items and %d repetitions\n", n,m);

        //Create all events
        //IEventQueue<Event> queue = new LinkedListEventQueue<>();
        ArrayList<Experiment> experiments = new ArrayList<>();
        createExperiments(experiments);

        System.out.println("Performing JIT prewarm with 4 repetitions:");
        for(int i = 0; i < experiments.size(); i++){
            experiments.get(i).initialize(n);
            experiments.get(i).evaluate(4);
        }

        createExperiments(experiments);

        System.out.println("Starting experiment:");
        for(int i = 0; i < experiments.size(); i++){
            experiments.get(i).initialize(n);
            experiments.get(i).evaluate(m);
        }

    }

    private static void createExperiments(ArrayList<Experiment> experiments) {
        experiments.clear();
        experiments.add(new Experiment("SplitListEventQueue", new SplitListEventQueue<>()));
        experiments.add(new Experiment("SortedArrayEventQueue", new SortedArrayEventQueue<Event>()));
        experiments.add(new Experiment("UnsortedArrayEventQueue", new UnsortedArrayEventQueue<Event>()));
        //experiments.add(new Experiment("LinkedListEventQueue", new LinkedListEventQueue<>()));
        experiments.add(new Experiment("ArrayListEventQueue", new ArrayListEventQueue<>()));
    }
}
