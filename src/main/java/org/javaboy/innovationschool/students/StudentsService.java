package org.javaboy.innovationschool.students;

import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentsService {

    List<StudentEntity> findAll();
    Optional<StudentEntity> findById(Long id);
    StudentEntity save(StudentDto studentDto);
    StudentEntity update(StudentEntity studentEntity);
    Set<StudentEntity> findByName(String name);
    void deleteById(Long id);
    StudentDto partialUpdate(StudentDto studentDto, Long id);
    Page<StudentDto> findAllPageable(Pageable pageable);

    //__________________________________________________________________________________________________________________
    void deleteStudent(StudentDto studentDto);
    List<StudentDto> getSortedStudents(String sortBy, String direction);

}
