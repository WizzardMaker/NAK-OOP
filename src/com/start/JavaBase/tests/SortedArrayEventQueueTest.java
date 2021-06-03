package com.start.JavaBase.tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.SortedArrayEventQueue;

public class SortedArrayEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new SortedArrayEventQueue();
    }
}
