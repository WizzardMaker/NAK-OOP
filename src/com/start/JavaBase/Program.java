package com.start.JavaBase;

import java.util.Random;

public class Program {
    static Random r = new Random();
    public static void main(String[] args) {
        int n = 10000, m = 1;

        //Create all events
        Event[] events = createEvents(n);
        IEventQueue<Event> queue = new ArrayListEventQueue<Event>();
        //IEventQueue<Event> queue = new LinkedListEventQueue<>();

        System.out.println("Starting \"enqueue and dequeue\"...");
        Stopwatch s = new Stopwatch();
        s.start();
        for(int rep = 0; rep < m; rep++) {
            for (int i = 0; i < n; i++) {
                queue.enqueue(r.nextDouble()*1000d,events[i]);
            }
            for(int i = 0; i < n; i++){
                queue.dequeue();
            }
        }
        s.stop();
        System.out.println("Time needed for \"enqueue and dequeue\": " + s.msElapsed + "ms");
    }

    private static Event[] createEvents(int n) {
        Event[] events = new Event[n];
        for(int i = 0; i < n; i++){
            events[i] = Event.getRandomEvent();
        }
        return events;
    }
}
