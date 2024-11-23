package org.javaboy.innovationschool.trainings;

import jakarta.persistence.*;

@Entity     //Reprezenton tabelen tone te databazes. Per me te manipuluar me databazen tone.
@Table(name = "trainings")      //Sepse atje e kemi trainings, e ketu TrainingEntity.
public class TrainingEntity {

    /*
        Validime mundemi me bo ketu, por mundemi edhe ne databaze qe me kufizu sa me shume aplikacionin tone.
        Pra validation checks eshte mire me i pase edhe ne kod edhe ne databaze.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // i gjeneron vlerat ne menyre automatike.
    private long id;
    private String title;
    private String description;
    private double price;
    private String cover;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
