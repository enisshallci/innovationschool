package org.javaboy.innovationschool.students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

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
