package org.javaboy.innovationschool.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> findAll() {

        List<StudentEntity> studentEntities = studentsService.findAll();

        return studentEntities;
    }

    @GetMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity getById(@PathVariable Long id) {

        return studentsService.findById(id).orElse(null);
    }

    @PostMapping(path = "/students")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity save(@RequestBody StudentEntity studentEntity) {

        return studentsService.save(studentEntity);
    }

    @GetMapping(path = "/students", params = "name")
    @ResponseStatus(HttpStatus.OK)
    public Set<StudentEntity> findByName(@RequestParam String name) {

        return studentsService.findByName(name);
    }


    @PutMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity update(@RequestBody StudentEntity studentEntity, @PathVariable Long id) {

        studentEntity.setId(id);
        return studentsService.update(studentEntity);
    }


    @DeleteMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        studentsService.deleteById(id);
    }


}
