package com.start.JavaBase.criterias;

import com.start.JavaBase.criterias.ICriteria;
import com.start.JavaBase.criterias.IState;

public class TestCriteria implements ICriteria
{
    @Override
    public void reset() { }

    @Override
    public boolean shouldStop(IState e){
        return true;
    }
}
