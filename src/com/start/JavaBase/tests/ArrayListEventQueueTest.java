package com.start.JavaBase.tests;

import com.start.JavaBase.ArrayListEventQueue;
import com.start.JavaBase.IEventQueue;

public class ArrayListEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new ArrayListEventQueue();
    }
}
