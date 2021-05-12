package com.start.JavaBase;

import java.util.Comparator;

public class ComparatorSplitList implements Comparator<IEventQueue.IEntry> {
    @Override
    public int compare(IEventQueue.IEntry o1, IEventQueue.IEntry o2) {
        return Double.compare(o1.getTime(), o2.getTime());
    }
}
