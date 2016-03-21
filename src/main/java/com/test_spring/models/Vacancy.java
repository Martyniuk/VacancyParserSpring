package com.test_spring.models;


/**
 * Created by vladimir on 04.02.16.
 */

public class Vacancy {

    private int id;
    private String link;
    private String title;
    private String city;
    private String description;
    private String dateOfPublication;
    private String typeOfEmployment;
    private String companyName; // TODO create class Company(name, logo, email, tel ,about, location)
    private String experienceOfWork;
    private boolean show;
    private String keyWord;    // TODO change to array

    public Vacancy() {
    }

    public int getId() {
        return id;
    }
    public boolean isShow() {
        return show;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public String getCity() {
        return city;
    }
    public String getLink() {
        return link;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getDateOfPublication() {
        return dateOfPublication;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getTypeOfEmployment() {
        return typeOfEmployment;
    }
    public String getExperienceOfWork() {
        return experienceOfWork;
    }

    public static Builder newBuilder() {
        return new Vacancy().new Builder();
    }

    // Builder Pattern
    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setId(int id) {
            Vacancy.this.id = id;

            return this;
        }

        public Builder setLink(String link) {
            Vacancy.this.link = link;

            return this;
        }

        public Builder setTitle(String title) {
            Vacancy.this.title = title;

            return this;
        }

        public Builder setCity(String city) {
            Vacancy.this.city = city;

            return this;
        }

        public Builder setDescription(String description) {
            Vacancy.this.description = description;

            return this;
        }

        public Builder setDateOfPublication(String dateOfPublication) {
            Vacancy.this.dateOfPublication = dateOfPublication;

            return this;
        }

        public Builder setTypeOfEmployment(String typeOfEmployment) {
            Vacancy.this.typeOfEmployment = typeOfEmployment;

            return this;
        }

        public Builder setCompanyName(String companyName) {
            Vacancy.this.companyName = companyName;

            return this;
        }

        public Builder setExperienceOfWork(String experienceOfWork) {
            Vacancy.this.experienceOfWork = experienceOfWork;

            return this;
        }

        public Builder setShow(boolean show) {
            Vacancy.this.show = show;

            return this;
        }

        public Builder setKeyWord(String keyWord) {
            Vacancy.this.keyWord = keyWord;

            return this;
        }

        public Vacancy build() {
            return Vacancy.this;
        }
    }
}

