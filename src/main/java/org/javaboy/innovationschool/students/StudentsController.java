package org.javaboy.innovationschool.students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     //Per me tregu qe eshte RestController, spring boot e interpreton si restController.
public class StudentsController {

    /*
        Forma e komunikimit te HTTP, ne path /students ne serverin tone do te thirret metoda getStudent()
        Pra, Spring boot i mappon GET requests ne URL e specifikuar me "/students" me këtë metodë.
     */
    @GetMapping(path = "/students/{id}")
    public Student getStudent() {

        Student studentModel = new Student();
        studentModel.setId(12l);
        studentModel.setFirstName("Enis");
        studentModel.setLastName("Shallci");
        studentModel.setProfilePicture(null);

        return studentModel;
    }

    @PostMapping(path = "/trainings")
    public String getTraining() {

        return "Spring Boot and Microservices 2024";
    }

}
