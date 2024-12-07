package org.javaboy.innovationschool.students;

import org.javaboy.innovationschool.students.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentsRepository extends JpaRepository<StudentEntity, Long> {

    Set<StudentEntity> findByFirstNameStartingWithIgnoreCaseAndDeletedAtIsNull(String name);    //metode e derivuar.

    List<StudentEntity> findAllByDeletedAtIsNull();

}
