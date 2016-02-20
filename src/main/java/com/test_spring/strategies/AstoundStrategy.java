package com.test_spring.strategies;


import com.test_spring.bean.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 21.01.16.
 */
public class AstoundStrategy implements Strategy {

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchPrLanguage) {
        Document doc;
        ArrayList<Vacancy> listOfVacancies = new ArrayList<>();

        try {

            doc = Jsoup.connect("http://astoundcommerce.com/category/careers/?directions=3&location=1&level=0").get();
            Elements elements = doc.select("#content .row .article_title");
            for (Element element : elements) {

                Document vacancySite = Jsoup.connect(element.attr("href")).get();

                Elements description = vacancySite.select("div.entry-content.single_empty_p");

                String vacancyLink = element.attr("href");
                String vacancyTitle = element.text();
                String vacancyDescription = description.text();
                String vacancyDateOfPublication = "no Date";
                String vacancyCompanyName = "Astound Commerce";
                String vacancyCity = "Kiev";
                String vacancyTypeOfEmployment = "full";
                String vacancyExperienceOfWork = "-||-";
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

