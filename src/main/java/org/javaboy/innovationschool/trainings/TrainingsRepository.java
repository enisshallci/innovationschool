package org.javaboy.innovationschool.trainings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrainingsRepository extends JpaRepository<TrainingEntity, Long> {

    Set<TrainingEntity> findByTitleIgnoreCase(String title);
}
