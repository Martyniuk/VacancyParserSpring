package com.test_spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("com")
@ImportResource({"classpath:database/dataSource.xml", "classpath:vacancy/vacancySpring.xml"})
@Configuration
public class VacancyAppConfig {
}
