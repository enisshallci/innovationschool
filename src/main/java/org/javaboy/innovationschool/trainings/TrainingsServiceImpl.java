package org.javaboy.innovationschool.trainings;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainingsServiceImpl implements TrainingsService {

    private TrainingsRepository trainingsRepository;

    public TrainingsServiceImpl(TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    @Override
    public List<TrainingEntity> findAll() {

        List<TrainingEntity> trainingEntities = trainingsRepository.findAll();
        if (trainingEntities.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "The list of trainings is null.");
        }

        return trainingsRepository.findAll();
    }

    @Override
    public Optional<TrainingEntity> findById(Long id) {

        if (trainingsRepository.findById(id).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The training with id " + id + " is not foumd.");
        }

        return trainingsRepository.findById(id);
    }

    @Override
    public Set<TrainingEntity> findByName(String title) {

        if (trainingsRepository.findByTitleStartingWithIgnoreCase(title).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no training that starts with " + title);
        }

        return trainingsRepository.findByTitleStartingWithIgnoreCase(title);
    }

    @Override
    public TrainingEntity save(TrainingEntity trainingEntity) {

        return trainingsRepository.save(trainingEntity);
    }

    @Override
    public TrainingEntity update(TrainingEntity trainingEntity) {

        return trainingsRepository.save(trainingEntity);
    }

    @Override
    public void deleteById(Long id) {

        if (findById(id).isPresent())
        {
            trainingsRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Training with id " + id + " not found.");
        }
    }

    @Override
    public Page<TrainingEntity> findAllPageable(Pageable pageable) {       //16

        return trainingsRepository.findAllByDeletedAtIsNull(pageable);
    }
}
