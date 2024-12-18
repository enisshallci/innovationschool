package org.javaboy.innovationschool.trainings.subjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.javaboy.innovationschool.commons.BaseEntity;
import org.javaboy.innovationschool.trainings.TrainingEntity;

@Entity
@Table(name = "subjects")
public class SubjectEntity extends BaseEntity {
    private String title;
    private String description;
    private String icon;

    @ManyToOne  // Relacioni i subjects me trainings.
    @JoinColumn(name = "training_id")       //Sepse ne databaze kolona e ka emrin training_id (FOREIGN KEY)
    @JsonIgnoreProperties("subjects")     //Bone ignore nje property te quajtur subjects tek training.
    private TrainingEntity training;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public TrainingEntity getTraining() {
        return training;
    }

    public void setTraining(TrainingEntity training) {
        this.training = training;
    }
}
