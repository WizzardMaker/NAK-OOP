package com.start.JavaBase.Tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.SortedArrayEventQueue;
import com.start.JavaBase.UnsortedArrayEventQueue;

public class UnsortedArrayEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new UnsortedArrayEventQueue();
    }
}
