package com.test_spring.Mappers;


import com.test_spring.models.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VacancyMapper implements RowMapper<Vacancy> {

    @Override
    public Vacancy mapRow(ResultSet resultSet, int i) throws SQLException {

        Vacancy vacancy = Vacancy.newBuilder()
        .setId(resultSet.getInt("id"))
        .setLink(resultSet.getString("link"))
        .setTitle(resultSet.getString("title"))
        .setCity(resultSet.getString("city"))
        .setDescription(resultSet.getString("description"))
        .setDateOfPublication(resultSet.getString("dateOfPublication"))
        .setTypeOfEmployment(resultSet.getString("typeOfEmployment"))
        .setCompanyName(resultSet.getString("companyName"))
        .setExperienceOfWork(resultSet.getString("experienceOfWork"))
        .setShow(resultSet.getBoolean("show"))
        .setKeyWord(resultSet.getString("keyWord")).build();

        return vacancy;
    }
}
