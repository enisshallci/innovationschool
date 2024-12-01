package org.javaboy.innovationschool.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping(path = "/trainings", params = "title")
    public Set<TrainingEntity> getByName(@RequestParam String title) {

        return trainingService.findByName(title);
    }

    @PostMapping(path = "/trainings")
    public TrainingEntity save(@RequestBody TrainingEntity trainingEntity) {

        return trainingService.save(trainingEntity);
    }
}
