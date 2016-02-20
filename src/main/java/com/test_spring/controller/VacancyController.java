package com.test_spring.controller;


import com.test_spring.bean.Vacancy;
import com.test_spring.dao.impl.JDBCVacancyDAO;
import com.test_spring.strategies.AstoundStrategy;
import com.test_spring.strategies.CiklumStrategy;
import com.test_spring.tools.Provider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;


@Controller
public class VacancyController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginMapping() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        List<Vacancy> list = getContext().getVacanciesFromDB();

        modelAndView.addObject("login",list);

        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public ModelAndView parseSites() {
        VacancyService service = new VacancyService(new Provider(new AstoundStrategy()), new Provider(new CiklumStrategy()));
        service.addVacanciesToDb();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        List<Vacancy> list = getContext().getVacanciesFromDB();

        modelAndView.addObject("login",list);
        return modelAndView;
    }
    @RequestMapping(value = "/parse", method = RequestMethod.GET)
    public void parseSites1() {

    }

    public JDBCVacancyDAO getContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springModule.xml");
        JDBCVacancyDAO jdbcVacancyDAO = (JDBCVacancyDAO) context.getBean("jdbcVacancyDAO");
        return jdbcVacancyDAO;
    }
}
