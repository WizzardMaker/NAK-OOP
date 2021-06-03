package com.start.JavaBase.tests;

import com.start.JavaBase.IEventQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

interface IEventQueueTest {
    IEventQueue create();

    ArrayList<String> list = new ArrayList();
    ArrayList<Integer> list1 = new ArrayList<>();

    @Test
    default void enqueueAndDequeue() {
        IEventQueue queue = create();
        assertEquals(0, queue.getLength());



        double[] testData = new double[]{9, 2, 5, 8, 0, 1, 3, 4, 6, 7};

        for(double d : testData){
            queue.enqueue(d, null);
        }

        assertEquals(queue.getLength(), 10);

        double[] recievedTest = new double[10];

        dequeue(queue, recievedTest);

        double[] correctTestData = new double[]{0, 1, 2, 3 ,4 ,5 ,6 ,7, 8, 9};
        assertArrayEquals(correctTestData, recievedTest);

        assertEquals(queue.getLength(), 0);
    }

    static void shuffleArray(double[] ar) {
        Random rnd = new Random();
        rnd.setSeed(42);

        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            double a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @Test
    default void enqueueAndDequeueLarge() {
        IEventQueue queue = create();
        assertEquals(0, queue.getLength());

        final int size = 5000;
        double[] testData = new double[size];
        Arrays.setAll(testData, i -> i + 1);

        shuffleArray(testData);

        for(double d : testData){
            queue.enqueue(d, null);
        }

        assertEquals(queue.getLength(), size);

        double[] recievedTest = new double[size];

        dequeue(queue, recievedTest);

        double[] correctTestData = new double[size];
        Arrays.setAll(correctTestData, i -> i + 1);
        assertArrayEquals(correctTestData, recievedTest);

        assertEquals(queue.getLength(), 0);
    }

    private void dequeue(IEventQueue queue, double[] recievedTest) {
        for(int i = 0; i< recievedTest.length; i++){
            IEventQueue.IEntry testItem = queue.dequeue();
            recievedTest[i] = testItem.getTime();

            assertEquals(null, testItem.getEvent());
            System.out.print(recievedTest[i]+ ", ");
        }
        System.out.print("-\n");
    }
}