package com.start.JavaBase.tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.UnsortedArrayEventQueue;

public class UnsortedArrayEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new UnsortedArrayEventQueue();
    }
}
