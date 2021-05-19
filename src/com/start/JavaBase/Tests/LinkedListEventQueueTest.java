package com.start.JavaBase.Tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.LinkedListEventQueue;
import com.start.JavaBase.UnsortedArrayEventQueue;

public class LinkedListEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new LinkedListEventQueue();
    }
}
