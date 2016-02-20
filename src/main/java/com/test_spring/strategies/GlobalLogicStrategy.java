package com.test_spring.strategies;

import com.test_spring.bean.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.01.2016.
 */
public class GlobalLogicStrategy implements Strategy{

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchPrLanguage) {
        ArrayList<Vacancy> listOfVacancies = new ArrayList<Vacancy>();
        Document doc;
        try {
            doc = Jsoup.connect("https://globallogic.com.ua/positions/kyiv/java/").timeout(10 * 1000).get();

            Elements elements = doc.select(".cl-link");

            for (int i = 0; i < elements.size(); i++) {

                Document vacancySite = Jsoup.connect(elements.get(i).attr("href")).timeout(20 * 1000).get();

                Elements description = vacancySite.select(".job-description");
                Elements dateOfPublication = elements.get(i).select("time[itemprop=datePublished]");
                Elements title = vacancySite.select(".content-title");

                String vacancyLink = elements.get(i).attr("href");
                String vacancyTitle = title.text();
                String vacancyDescription = description.text();
                String vacancyDateOfPublication = dateOfPublication.text();
                String vacancyCompanyName = "Global Logic";
                String vacancyCity = "Kyiv";
                String vacancyTypeOfEmployment = "full Time";
                String vacancyWorkExperience = "There is no working experience needed!!";
                boolean isShown = true;
                String keyWord = "";

                try {
                    vacancyWorkExperience = null;
                } catch (NullPointerException e) {
                    System.out.println("There is no working experience needed!!   " +
                            "APPLY NOW!!!!");
                }

                Vacancy vacancyObject = Vacancy.newBuilder()
                        .setLink(vacancyLink)
                        .setTitle(vacancyTitle)
                        .setCity(vacancyCity)
                        .setDescription(vacancyDescription)
                        .setDateOfPublication(vacancyDateOfPublication)
                        .setTypeOfEmployment(vacancyTypeOfEmployment)
                        .setCompanyName(vacancyCompanyName)
                        .setExperienceOfWork(vacancyWorkExperience)
                        .setShow(isShown)
                        .setKeyWord(keyWord).build();
                listOfVacancies.add(vacancyObject);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return listOfVacancies;
    }
}
