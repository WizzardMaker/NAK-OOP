package com.start.JavaBase.criterias;

public interface ICriteria
{
    void reset();
    boolean shouldStop(IState e);
}
