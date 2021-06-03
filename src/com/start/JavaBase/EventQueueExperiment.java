package com.start.JavaBase;

import com.start.JavaBase.criterias.CriteriaCollection;
import com.start.JavaBase.criterias.IState;

import java.lang.reflect.InvocationTargetException;
import java.rmi.activation.Activator;
import java.util.Random;

public class EventQueueExperiment implements IExperiment {
    Random r = new Random();
    Event[] events;
    IEventQueue<Event> queue;
    String name;

    CriteriaCollection criterias = null;

    EventQueueExperiment(String name, IEventQueue<Event> implementation){
        queue = implementation;
        this.name = name;
    }

    EventQueueExperiment(String name, String implementationName){
        Class c = null;
        try {
            c = Class.forName(implementationName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            queue = (IEventQueue<Event>) c.getConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        this.name = name;
    }

    /**
     * Prepares the experiment, by creating the events
     * @param initialSize - the amount of events to test the IEventQueue on
     */
    @Override
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

    @Override
    public void setCriterias(CriteriaCollection criterias){
        this.criterias = criterias;
    }

    /**
     * Tests the IEventQueue with enqueue and dequeue operations
     * Each enqueue is with a random number from a fixed seed
     * @return the time each repetition needed
     */
    @Override
    public Statistics execute() {
        r.setSeed(42);

        Statistics stats = new Statistics();
        EventQueueState state = new EventQueueState();

        System.out.println("Starting \""+name+"'s\" \"enqueue and dequeue\"...");
        Stopwatch stopwatch = new Stopwatch();

        while(!criterias.shouldStop(state)){
            stopwatch.restart();

            for (int i = 0; i < events.length; i++) {
                queue.enqueue(r.nextDouble()*1000d,events[i]);
            }
            for(int i = 0; i < events.length; i++){
                queue.dequeue();
            }

            stopwatch.stop();
            stats.addRep(stopwatch.getMsElapsed());
            state.previousTime = state.currentTime;
            state.currentTime = stopwatch.getMsElapsed();
        }

        //float timePerPair = (stopwatch.nsElapsed/((float)repetitions*events.length));
        System.out.println("Time needed for  \""+name+"'s\" \"enqueue and dequeue\": " + stats.getTotalRunTime() + "ms and with each rep taking ca. " + stats.getAverageRepTime() + "ms");
    
        return stats;
    }

    public class EventQueueState implements IState {
        float currentTime, previousTime;
        @Override
        public float getCurrentTime() {
            return currentTime;
        }

        @Override
        public float getPreviousTime() {
            return previousTime;
        }
    }
}
