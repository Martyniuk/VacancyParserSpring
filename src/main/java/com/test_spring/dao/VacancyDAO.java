package com.test_spring.dao;

import com.test_spring.bean.Vacancy;

import java.util.List;

/**
 * Created by vladimir on 08.02.16.
 */

public interface VacancyDAO {

    void createTable();
    //TODO rename to saveVacancy
    //TODO into "addVacancy" method insert Vacancy, not fields
    void addVacancy(String link,
                    String title,
                    String city,
                    String description,
                    String dateOfPublication,
                    String typeOfEmployment,
                    String companyName,
                    String experienceOfWork,
                    boolean show,
                    String keyWord);

    List<Vacancy> getVacanciesFromDB();

}
