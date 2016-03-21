package com.test_spring.dao;

import com.test_spring.models.Vacancy;

import java.util.List;

/**
 * Created by vladimir on 08.02.16.
 */

public interface VacancyDAO {

    void createTable();
    void saveVacancy(Vacancy vacancy);
    List<Vacancy> getVacanciesFromDB();

}
