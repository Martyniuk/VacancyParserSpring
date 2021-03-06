package com.test_spring.dao.impl;

import com.test_spring.models.Vacancy;
import com.test_spring.Mappers.VacancyMapper;
import com.test_spring.dao.VacancyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JDBCVacancyDAO  implements VacancyDAO {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTable() {

      JdbcTemplate  jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "CREATE TABLE `vacancies` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `link` VARCHAR(200) DEFAULT NULL,\n" +
                "  `title` VARCHAR(100) DEFAULT NULL,\n" +
                "  `city` VARCHAR(500) DEFAULT NULL,\n" +
                "  `description` TEXT,\n" +
                "  `dateOfPublication` VARCHAR(50) DEFAULT NULL,\n" +
                "  `typeOfEmployment` VARCHAR(50) DEFAULT NULL,\n" +
                "  `companyName` VARCHAR(20) DEFAULT NULL,\n" +
                "  `experienceOfWork` VARCHAR(300) DEFAULT NULL,\n" +
                "  `show` BOOLEAN DEFAULT NULL,\n" +
                "  `keyWord` VARCHAR(200) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `link_UNIQUE` (`link`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";

        jdbcTemplate.execute(sql);
    }

    public void saveVacancy(Vacancy vacancy) {

        String sql = "INSERT INTO `vacancies`.`vacancies` (`link`,`title`,`city`,`description`,`dateOfPublication`,`typeOfEmployment`,`companyName`,`experienceOfWork`,`show`,`keyWord`) VALUES (?,?,?,?,?,?,?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, vacancy.getLink(), vacancy.getTitle(), vacancy.getCity(), vacancy.getDescription(), vacancy.getDateOfPublication(), vacancy.getTypeOfEmployment(), vacancy.getCompanyName(), vacancy.getExperienceOfWork(), vacancy.isShow(), vacancy.getKeyWord());

    }

    public List<Vacancy> getVacanciesFromDB() {

        String sql = "SELECT * FROM vacancies.vacancies";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Vacancy> vacancies =  jdbcTemplate.query(sql, new VacancyMapper());

        return vacancies;
    }
}
