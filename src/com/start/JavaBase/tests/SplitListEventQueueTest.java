package com.start.JavaBase.tests;

import com.start.JavaBase.IEventQueue;
import com.start.JavaBase.SplitListEventQueue;

public class SplitListEventQueueTest implements IEventQueueTest{

    @Override
    public IEventQueue create() {
        return new SplitListEventQueue();
    }
}
