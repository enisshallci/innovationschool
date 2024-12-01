package org.javaboy.innovationschool.trainings;

import jakarta.persistence.*;
import org.javaboy.innovationschool.commons.BaseEntity;

@Entity
@Table(name = "trainings")
public class TrainingEntity extends BaseEntity {

    private String title;
    private String description;
    private double price;
    private String cover;

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

// TODO: Ushtroj Optionals
// TODO: Ushtroj queries te derivuara
// TODO: Ushtroj
// TODO: Kqyr Annotations per renditjen e attributeve ne postman me na dal mire.
// TODO: Annotation qe me na bo set nje date per createdAt tek setat.