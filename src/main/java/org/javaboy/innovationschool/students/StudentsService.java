package org.javaboy.innovationschool.students;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentsService {

    List<StudentEntity> findAll();
    Optional<StudentEntity> findById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    Set<StudentEntity> findByName(String name);

}
