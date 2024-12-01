package org.javaboy.innovationschool.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingsController {

    private TrainingService trainingService;

    @Autowired
    public TrainingsController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(path = "/trainings")
    public List<TrainingEntity> findAll() {

        return trainingService.findAll();
    }

    @GetMapping(path = "/trainings/{id}")
    public TrainingEntity getById(@PathVariable Long id) {

        return trainingService.findById(id).orElse(null);
    }


}
