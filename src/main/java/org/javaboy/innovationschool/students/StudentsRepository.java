package org.javaboy.innovationschool.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentsRepository extends JpaRepository<StudentEntity, Long> {

    Set<StudentEntity> findByFirstNameStartingWith(String name);    //metode e derivuar.

}
