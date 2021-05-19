package com.start.JavaBase.Tests;

import com.start.JavaBase.ArrayListEventQueue;
import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.LinkedListEventQueue;

public class ArrayListEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new ArrayListEventQueue();
    }
}
