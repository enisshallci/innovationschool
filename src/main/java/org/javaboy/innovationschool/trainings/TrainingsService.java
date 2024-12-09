package org.javaboy.innovationschool.trainings;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TrainingsService {

    List<TrainingEntity>  findAll();
    Optional<TrainingEntity> findById(Long id);
    Set<TrainingEntity> findByName(String title);
    TrainingEntity save(TrainingEntity trainingEntity);
    TrainingEntity update(TrainingEntity trainingEntity);
    void deleteById(Long id);
    Page<TrainingEntity> findAllPageable(Pageable pageaable);           // 16
}
