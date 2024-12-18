package org.javaboy.innovationschool.trainings;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.javaboy.innovationschool.commons.BaseEntity;
import org.javaboy.innovationschool.trainings.subjects.SubjectEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class TrainingEntity extends BaseEntity {

    @NotBlank(message = "Training title must be specified.")
    @Size(max = 150, message = "Title length must not exceed 150 characters.")
    private String title;

    @NotBlank(message = "Training description must be provided.")
    @Size(max = 600, message = "Description length must not exceed 150 characters.")
    private String description;

    @NotBlank(message = "Training price must be specified.")
    @Positive(message = "Training price must be greater than zero.")
    private double price;
    private String cover;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)   //i tregojna cila fushe e menaxhon kete relacion.
    private Set<SubjectEntity> subjects = new HashSet<>();

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

    public Set<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectEntity> subjects) {
        this.subjects = subjects;
    }
}





// TODO: Annotation qe me na bo set nje date per createdAt tek setat.
// TODO: Kur del te ResponseEntity kqyr do far URI location e ksi pervetesoj qato.