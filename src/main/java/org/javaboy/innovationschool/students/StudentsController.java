package org.javaboy.innovationschool.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StudentsController {

    private StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping(path = "/students")
    public List<StudentEntity> findAll() {

        List<StudentEntity> studentEntities = studentsService.findAll();

        return studentEntities;
    }

    @GetMapping(path = "/students/{id}")
    public StudentEntity getById(@PathVariable Long id) {

        return studentsService.findById(id).orElse(null);
    }

    @PostMapping(path = "/students")
    public StudentEntity save(@RequestBody StudentEntity studentEntity) {

        return studentsService.save(studentEntity);
    }

    @GetMapping(path = "/students", params = "name")        //tipi i metodes ne HTTP protokollin tone.
    public Set<StudentEntity> findByName(@RequestParam String name) {

        return studentsService.findByName(name);
    }

}
