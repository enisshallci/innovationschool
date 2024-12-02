package org.javaboy.innovationschool.trainings;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.javaboy.innovationschool.commons.BaseEntity;

@Entity
@Table(name = "trainings")
public class TrainingEntity extends BaseEntity {

    @NotNull(message = "Training title must be specified.")
    @Size(max = 150, message = "Title length must not exceed 150 characters.")
    private String title;

    @NotNull(message = "Training description must be provided.")
    @Size(max = 600, message = "Description length must not exceed 150 characters.")
    private String description;

    @NotNull(message = "Training price must be specified.")
    @Positive(message = "Training price must be greater than zero.")
    private double price;
    private String cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.length() > 150) {
            throw new IllegalArgumentException("Title must not be null and should not exceed 150 characters.");
        }
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

        String priceStr = String.valueOf(price);
        if (priceStr.contains(".") && priceStr.split("\\.")[1].length() > 2) {
            throw new IllegalArgumentException("Price must have at most 2 decimal places.");
        }

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
// TODO: Kur del te ResponseEntity kqyr do far URI location e ksi pervetesoj qato.