package com.martyniuk.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String name;
    @OneToMany(targetEntity = Travel.class, mappedBy = "creator",
                cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    /*@JoinColumn(name = "userId")*/
    private List<Travel> journeys;


    public List<Travel> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Travel> journeys) {
        this.journeys = journeys;
    }

    public User () {}

    public User(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", votes="   +
                '}';
    }
}
