package org.javaboy.innovationschool.trainings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsRepository extends JpaRepository<TrainingEntity, Long> {      //duhet me perdor nje librari te data JPA

    //ka metoda


}
