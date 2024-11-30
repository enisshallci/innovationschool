package org.javaboy.innovationschool.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentsController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping(path = "/students")
    public List<StudentEntity> findAll() {

        List<StudentEntity> studentEntities = studentsRepository.findAll();

        return studentEntities;
    }

    @GetMapping(path = "/students/{id}")
    public StudentEntity getById(@PathVariable Long id) {

        return studentsRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/students")
    public StudentEntity save(@RequestBody StudentEntity studentEntity) {

        return studentsRepository.save(studentEntity);
    }


}
