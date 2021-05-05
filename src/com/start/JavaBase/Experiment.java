package com.start.JavaBase;

import java.util.Random;

public class Experiment {
    Random r = new Random();
    Event[] events;
    IEventQueue<Event> queue;
    String name;

    Experiment(String name, IEventQueue<Event> implementation){
        queue = implementation;
        this.name = name;
    }

    /**
     * Prepares the experiment, by creating the events
     * @param initialSize - the amount of events to test the IEventQueue on
     */
    public void initialize(int initialSize){
        events = createEvents(initialSize);
    }

    private static Event[] createEvents(int n) {
        Event[] events = new Event[n];
        for(int i = 0; i < n; i++){
            events[i] = Event.getRandomEvent();
        }
        return events;
    }


    /**
     * Tests the IEventQueue with enqueue and dequeue operations
     * Each enqueue is with a random number from a fixed seed
     * @param repetitions - the amount of enqueue/dequeue repetitions for each iteration
     * @return the time each repetition needed
     */
    public float evaluate(int repetitions) {
        r.setSeed(42);

        System.out.println("Starting \""+name+"'s\" \"enqueue and dequeue\"...");
        Stopwatch s = new Stopwatch();
        s.start();
        for(int rep = 0; rep < repetitions; rep++) {
            for (int i = 0; i < events.length; i++) {
                queue.enqueue(r.nextDouble()*1000d,events[i]);
            }
            for(int i = 0; i < events.length; i++){
                queue.dequeue();
            }
        }
        s.stop();

        float timePerPair = (s.nsElapsed/((float)repetitions*events.length));
        System.out.println("Time needed for  \""+name+"'s\" \"enqueue and dequeue\": " + s.getMsElapsed() + "ms and with each entry taking ca. " + timePerPair + "ns");
    
        return timePerPair;
    }
}
