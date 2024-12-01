package org.javaboy.innovationschool.trainings;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    List<TrainingEntity>  findAll();
    Optional<TrainingEntity> findById(Long id);

}
