package com.test_spring.controller;


import com.test_spring.models.Vacancy;
import com.test_spring.dao.VacancyDAO;
import com.test_spring.tools.Provider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class VacancyService {
    private Provider[] providers;

    public VacancyService(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    public List<Vacancy> scan() {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            List<Vacancy> vacancyList = provider.getJavaVacancies("kiev", "java");
            if (vacancyList != null) {
                vacancies.addAll(vacancyList.stream().collect(Collectors.toList()));
                /*for (Vacancy vacancy : vacancyList) {
                    vacancies.add(vacancy);
                }*/
            }
        }
        return vacancies;
    }

    public void addVacanciesToDb() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springModule.xml");
        VacancyDAO jdbcVacancyDAO = (VacancyDAO) context.getBean("jdbcVacancyDAO");
        List<Vacancy> vacancies = scan();
        vacancies.forEach(jdbcVacancyDAO::saveVacancy);
        /*for (Vacancy vacancy : vacancies) {
            jdbcVacancyDAO.saveVacancy(vacancy);
        }*/
    }
}
