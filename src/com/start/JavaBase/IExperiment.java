package com.start.JavaBase;

import com.start.JavaBase.criterias.CriteriaCollection;

public interface IExperiment {

    void initialize(int initialSize);

    void setCriterias(CriteriaCollection criterias);

    Statistics execute();
}