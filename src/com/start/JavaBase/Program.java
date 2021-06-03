package com.start.JavaBase;

import com.start.JavaBase.criterias.CriteriaCollection;
import com.start.JavaBase.criterias.MaxRepetitionCriteria;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        int n = 200000, m = 3;

        System.out.printf("Running Experiment with %d items and %d repetitions\n", n,m);

        //Create all events
        //IEventQueue<Event> queue = new LinkedListEventQueue<>();
        ArrayList<IExperiment> experiments = new ArrayList<>();
        createExperiments(experiments);

        System.out.println("Performing JIT prewarm with 4 repetitions:");
        for(int i = 0; i < experiments.size(); i++)
        {
            experiments.get(i).initialize(n);
            experiments.get(i).execute();
        }

        createExperiments(experiments);

        System.out.println("Starting experiment:");
        for(int i = 0; i < experiments.size(); i++){
            experiments.get(i).initialize(n);
            experiments.get(i).execute();
        }
    }

    private static void createExperiments(ArrayList<IExperiment> experiments) {
        experiments.clear();
        experiments.add(new EventQueueExperiment("SplitListEventQueue Reflection", "com.start.JavaBase.SplitListEventQueue"));
        experiments.add(new EventQueueExperiment("SplitListEventQueue", new SplitListEventQueue<Event>()));
        experiments.add(new EventQueueExperiment("SortedArrayEventQueue", new SortedArrayEventQueue<Event>()));
        experiments.add(new EventQueueExperiment("UnsortedArrayEventQueue", new UnsortedArrayEventQueue<Event>()));
        //experiments.add(new Experiment("LinkedListEventQueue", new LinkedListEventQueue<>()));
        experiments.add(new EventQueueExperiment("ArrayListEventQueue", new ArrayListEventQueue<>()));

        for(IExperiment e: experiments) {
            e.setCriterias(CriteriaCollection.CreateSingleCriteria(new MaxRepetitionCriteria(5)));
        }
    }
}
