package com.test_spring.strategies;

import com.test_spring.models.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 02.01.2016.
 */
public class WorkUAStrategy implements Strategy{

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchPrLanguage) {
        Document doc;
        ArrayList<Vacancy> listOfVacancies = new ArrayList<Vacancy>();
        try {
            doc = Jsoup.connect("http://www.work.ua/jobs-kyiv-junior+java+developer/").get();

            Elements elements = doc.select(".card h2 a");

            for (Element e : elements) {

                Document vacancySite = Jsoup.connect("http://www.work.ua/" + e.attr("href")).get();

                Elements description = vacancySite.select(".card .overflow");
                Elements dateOfPublication = vacancySite.select(".card .text-muted");
                Elements companyName = vacancySite.select(".card .dl-horizontal a");
                Elements otherDescription = vacancySite.select(".card .dl-horizontal dd");

                String vacancyLink = "http://www.work.ua" + e.attr("href");
                String vacancyTitle = e.attr("title");
                String vacancyDescription = description.first().text();
                String vacancyDateOfPublication = dateOfPublication.first().text();
                String vacancyCompanyName = companyName.first().text();

                String vacancyCity = otherDescription.get(1).text();
                String vacancyTypeOfEmployment = otherDescription.get(2).text();
                String vacancyExperienceOfWork = "There is no working experience needed"; // конструктор может выебываться
                boolean isShown = true;
                String keyWord = "";

                Vacancy vacancyObject = Vacancy.newBuilder()
                        .setLink(vacancyLink)
                        .setTitle(vacancyTitle)
                        .setCity(vacancyCity)
                        .setDescription(vacancyDescription)
                        .setDateOfPublication(vacancyDateOfPublication)
                        .setTypeOfEmployment(vacancyTypeOfEmployment)
                        .setCompanyName(vacancyCompanyName)
                        .setExperienceOfWork(vacancyExperienceOfWork)
                        .setShow(isShown)
                        .setKeyWord(keyWord).build();
                listOfVacancies.add(vacancyObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfVacancies;
    }
}
