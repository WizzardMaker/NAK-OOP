package com.start.JavaBase.criterias;

public class MaxRepetitionCriteria implements ICriteria {
    private int reps = 0;
    private int maxReps;

    public MaxRepetitionCriteria(int maxRepetitions){
        maxReps = maxRepetitions;
    }

    @Override
    public void reset() {
        reps = 0;
    }

    @Override
    public boolean shouldStop(IState e) {
        return ++reps > maxReps;
    }
}
