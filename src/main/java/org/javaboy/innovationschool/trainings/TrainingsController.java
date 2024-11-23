package org.javaboy.innovationschool.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingsController {

    private TrainingsRepository trainingsRepository;

    @Autowired //per kete trainingRepository nalt si fushe, nuk e krijojme ne, vet krijohet si instance si bean edhe bohet map te kontrolleri jone.
    public TrainingsController(TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    @GetMapping(path = "/trainings")
    public List<TrainingEntity> findAll() {

        return trainingsRepository.findAll();
    }
}
