package org.javaboy.innovationschool.trainings;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingsServiceImpl implements TrainingService {

    private TrainingsRepository trainingsRepository;

    public TrainingsServiceImpl(TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    @Override
    public List<TrainingEntity> findAll() {

        return trainingsRepository.findAll();
    }

    @Override
    public Optional<TrainingEntity> findById(Long id) {

        return trainingsRepository.findById(id);
    }
}
