package com.test_spring.strategies;

import com.test_spring.bean.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CiklumStrategy implements Strategy {

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchPrLanguage) {
        Document doc;
        ArrayList<Vacancy> listOfVacancies = new ArrayList<Vacancy>();

        try {
            doc = Jsoup.connect("http://jobs.ciklum.com/?s=" +
                    "Java+Developer&location=&location=" +
                    "Kyiv&job_cat=&ptype=job_listing&latitude=&longitude=&full_address=&north_east_lng=&south_west_lng=&north_east_lat=&south_west_lat=").timeout(10 * 1000).get();

            Elements elements = doc.select("ol.jobs.searchapply .row .position-name a");  // проверено

            for (Element element : elements) {

                Document vacancySite = Jsoup.connect(element.attr("href")).timeout(10 * 10000).get();

                Elements title = vacancySite.select(".section_header h1");
                Elements description = vacancySite.select(".section_content p");
                Elements dateOfPublication = vacancySite.select("p.section-name");
                //  Elements experienceWork = vacancySite.select(".section_content ul li"); // неправильно сделал

                String vacancyLink = element.attr("href");
                String vacancyTitle = title.text();
                String vacancyDescription = description.text();
                String vacancyDateOfPublication = dateOfPublication.text();
                String vacancyCompanyName = "Ciklum";
                String vacancyCity = searchCity;
                String vacancyTypeOfEmployment = "full time";
                String vacancyWorkExperince = "no working experience needed!";
                boolean isShown = true;
                String keyWord = "";
                try {
                    vacancyWorkExperince = "WTF";
                } catch (NullPointerException e) {
                    System.out.println("no working exp needed");
                }

                Vacancy vacancyObject = Vacancy.newBuilder()
                        .setLink(vacancyLink)
                        .setTitle(vacancyTitle)
                        .setCity(vacancyCity)
                        .setDescription(vacancyDescription)
                        .setDateOfPublication(vacancyDateOfPublication)
                        .setTypeOfEmployment(vacancyTypeOfEmployment)
                        .setCompanyName(vacancyCompanyName)
                        .setExperienceOfWork(vacancyTypeOfEmployment)
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
