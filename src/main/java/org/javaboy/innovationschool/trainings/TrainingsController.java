package org.javaboy.innovationschool.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainingsController {

    private TrainingsRepository trainingsRepository;

    @Autowired
    public TrainingsController(TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    @GetMapping(path = "/trainings")
    public List<TrainingEntity> findAll() {

        return trainingsRepository.findAll();
    }

    @GetMapping(path = "/trainings/{id}")
    public TrainingEntity findById(@PathVariable Long id) {

        Optional<TrainingEntity> trainingEntityOptional = trainingsRepository.findById(id);

        if (trainingEntityOptional.isPresent()) {
            return trainingEntityOptional.get();
        }

        return null;
    }

}
