package com.start.JavaBase.Tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.SplitListEventQueue;
import com.start.JavaBase.UnsortedArrayEventQueue;

public class SplitListEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new SplitListEventQueue();
    }
}
