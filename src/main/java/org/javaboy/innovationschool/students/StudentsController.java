package org.javaboy.innovationschool.students;

import jakarta.validation.Valid;
import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public StudentEntity save(@Valid @RequestBody StudentDto studentDto) {

        return studentsService.save(studentDto);
    }

    @GetMapping(path = "/students", params = "name")
    @ResponseStatus(HttpStatus.OK)
    public Set<StudentEntity> findByName(@RequestParam String name) {

        return studentsService.findByName(name);
    }


    @PutMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity update(@Valid @RequestBody StudentEntity studentEntity, @PathVariable Long id) {

        studentEntity.setId(id);
        return studentsService.update(studentEntity);
    }


    @DeleteMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        studentsService.deleteById(id);
    }


    @PatchMapping(path = "/students/{id}")
    public StudentDto partialUpdate(@Valid @RequestBody StudentDto studentDto, @PathVariable Long id) {

        studentDto.setId(id);
        return studentsService.partialUpdate(studentDto, id);
    }


    @GetMapping(path = "/students", params = {"page", "size"})
    public ResponseEntity<?> findAllPageable(Pageable pageable) {

        Page<StudentDto> studentDtoPage = studentsService.findAllPageable(pageable);
        return ResponseEntity.ok(studentDtoPage);
    }


    //__________________________________________________________________________________________________________________
    //Ushtrimet e mia:


    @DeleteMapping(path = "/students")
    public void deleteStudent(@Valid @RequestBody StudentDto studentDto) {


        studentsService.deleteStudent(studentDto);
    }


    @GetMapping(path = "/students", params = {"sortBy", "direction"})
    public List<StudentDto> getSortedStudents(@RequestParam String sortBy, @RequestParam String direction) {

        return studentsService.getSortedStudents(sortBy, direction);
    }

    //sort and pagination
//    @GetMapping(path = "")

}


