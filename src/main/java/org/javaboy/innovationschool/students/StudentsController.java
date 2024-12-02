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

    @GetMapping(path = "/students", params = "name")        //tipi i metodes ne HTTP protokollin tone.
    @ResponseStatus(HttpStatus.OK)
    public Set<StudentEntity> findByName(@RequestParam String name) {

        return studentsService.findByName(name);
    }

    /*
        Nese nuk ia kishum jep Id:, ish shku e kish kriju nje student te ri ne databaze.
        Pra vime ne perfundim qe kur dojme me bo @PutMapping duhet me i barte te gjitha informatat qysh kane qene. Qe mos
        mu mbishkru me "null".
     */
    @PutMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity update(@RequestBody StudentEntity studentEntity, @PathVariable Long id) {

        studentEntity.setId(id);
        return studentsService.update(studentEntity);
    }

    //No content kur operacioni eshte kry me sukses, por nuk ka rezultat.
    @DeleteMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)      // nese eshte kthy me sukses operacioni me na kthy 204. Gjithqka me sukses percaktohet nga kjo.
    public void delete(@PathVariable Long id) {

        studentsService.deleteById(id);
    }

    //Nese nuk ka sukses shkon edhe mbishkruhet nga throw te services.

}
