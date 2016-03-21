package com.martyniuk.models;

import com.sun.corba.se.impl.ior.JIDLObjectKeyTemplate;

import javax.persistence.*;

@Entity
@Table
public class Rating {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer rate;

    @OneToOne
    @JoinColumn(name = "id")
    private Travel travel;

    public Rating(Integer rate) {

        this.rate = rate;
    }

    public Rating() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rate=" + rate +
                '}';
    }
}
