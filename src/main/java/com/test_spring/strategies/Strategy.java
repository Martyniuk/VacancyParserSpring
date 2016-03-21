package com.test_spring.strategies;

import com.test_spring.models.Vacancy;

import java.util.List;

// TODO rewrite all parsers.
public interface Strategy {
    List<Vacancy> getVacancies(String searchCity, String searchPrLanguage);

}
