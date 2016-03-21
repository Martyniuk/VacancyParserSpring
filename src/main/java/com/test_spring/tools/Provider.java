package com.test_spring.tools;


import com.test_spring.models.Vacancy;
import com.test_spring.strategies.Strategy;

import java.util.List;

/**
 * Created by vladimir on 21.01.16.
 */
public class Provider {

    private Strategy strategy;

    public Provider(Strategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchCity, String searchLanguage) {
        return strategy.getVacancies(searchCity, searchLanguage);
    }
}
