package org.javaboy.innovationschool.trainings;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrainingsRepository extends JpaRepository<TrainingEntity, Long> {

    Set<TrainingEntity> findByTitleStartingWithIgnoreCase(String title);
    Page<TrainingEntity> findAllByDeletedAtIsNull(Pageable pageable);
}
