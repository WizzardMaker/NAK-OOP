package com.start.JavaBase.tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.LinkedListEventQueue;

public class LinkedListEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new LinkedListEventQueue();
    }
}
