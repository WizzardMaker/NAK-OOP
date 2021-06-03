package com.start.JavaBase.criterias;

import com.start.JavaBase.criterias.ICriteria;
import com.start.JavaBase.criterias.IState;

import java.util.ArrayList;

public class CriteriaCollection {
    ArrayList<ICriteria> criterias = new ArrayList<>();

    public static CriteriaCollection CreateSingleCriteria(ICriteria criteria){
        CriteriaCollection c = new CriteriaCollection();
        c.addCriteria(criteria);

        return c;
    }

    public void addCriteria(ICriteria c) {
        criterias.add(c);
    }

    public void reset(){
        for(ICriteria c:criterias) {
            c.reset();
        }
    }

    public boolean shouldStop(IState state) {
        if(criterias.size() == 0){
            throw new IllegalStateException("Criteria Collection without a criteria would result in an infinite loop");
        }

        for(ICriteria c:criterias) {
            if(c.shouldStop(state))
                return true;
        }

        return false;
    }
}
