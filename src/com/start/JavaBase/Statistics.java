package com.start.JavaBase;
import java.util.ArrayList;

// Result of a
public class Statistics
{
    private float totalRunTime;
    private float slowestRep;
    private float fastestRep;
    private float averageRepTime;
    private boolean runsChanged;
    private ArrayList<Float> runs;

    public Statistics()
    {
        runsChanged = false;
        runs = new ArrayList<>();
    }

    public int getRunCount()
    {
        return runs.size();
    }

    public float getAverageRepTime()
    {
        sanityCheck();
        return averageRepTime;
    }

    public float getFastestRep()
    {
        sanityCheck();
        return fastestRep;
    }

    public float getSlowestRep()
    {
        sanityCheck();
        return slowestRep;
    }

    public float getTotalRunTime()
    {
        sanityCheck();
        return totalRunTime;
    }

    public void addRep(float run)
    {
        runs.add(run);
        runsChanged = true;
    }

    private void updateValues()
    {
        runsChanged = false;

        // Calc total Runtime,
        float slowestR = runs.get(0);
        float fastestR = runs.get(0);
        float totalRT = 0.f;
        for(float run : runs)
        {
            totalRT += run;

            if(run > slowestR)
                slowestR = run;

            if(run < fastestR)
                fastestR = run;
        }

        totalRunTime = totalRT;
        fastestRep = fastestR;
        slowestRep = slowestR;

        // Calc average RepTime
        // NEEDS TO BE CALLED AFTER TOTALRUNTIME!
        // Values will be false otherwise
        averageRepTime = totalRunTime / runs.size();
    }

    private void sanityCheck()
    {
        if(runs.size() == 0)
            throw new IllegalStateException("STATISTICS: There are currently no runs logged!");

        if(runsChanged)
            updateValues();
    }
}
