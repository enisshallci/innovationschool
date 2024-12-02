package org.javaboy.innovationschool.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class TrainingsController {

    private TrainingsService trainingService;

    @Autowired
    public TrainingsController(TrainingsService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(path = "/trainings")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingEntity> findAll() {

        return trainingService.findAll();
    }

    @GetMapping(path = "/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainingEntity getById(@PathVariable Long id) {

        return trainingService.findById(id).orElse(null);
    }

    @GetMapping(path = "/trainings", params = "title")
    @ResponseStatus(HttpStatus.OK)
    public Set<TrainingEntity> getByName(@RequestParam String title) {

        return trainingService.findByName(title);
    }

    @PostMapping(path = "/trainings")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingEntity save(@RequestBody TrainingEntity trainingEntity) {

        return trainingService.save(trainingEntity);
    }

    @PutMapping(path = "/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainingEntity update(@RequestBody TrainingEntity trainingEntity, @PathVariable Long id) {

        trainingEntity.setId(id);
        return trainingService.update(trainingEntity);
    }

    @DeleteMapping(path = "trainings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        trainingService.deleteById(id);
    }

}
