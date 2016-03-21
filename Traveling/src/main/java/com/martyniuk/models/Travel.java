package com.martyniuk.models;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Map;

@Entity
@Table(name = "travels")
public class Travel {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "userId", insertable=false, updatable=false)
    private User creator;
    private String text;
    @Temporal(TemporalType.DATE)
    private Calendar dateOfCreation;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "travel")
    private Rating rating;

    public Calendar getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Calendar dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    // private Map<User, Integer> votes;


    public Travel(User creator, String text, Calendar dateOfCreation) {
        this.creator = creator;
        this.text = text;
        this.dateOfCreation = dateOfCreation;
    }

    public Travel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", creator=" + creator +
                ", text='" + text + '\'' +
                ", votes="  +
                '}';
    }
}
