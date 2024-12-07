package org.javaboy.innovationschool.students;

import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentsService {

    List<StudentEntity> findAll();
    Optional<StudentEntity> findById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    StudentEntity update(StudentEntity studentEntity);
    Set<StudentEntity> findByName(String name);
    void deleteById(Long id);
    StudentDto partialUpdate(StudentDto studentDto, Long id);
}
