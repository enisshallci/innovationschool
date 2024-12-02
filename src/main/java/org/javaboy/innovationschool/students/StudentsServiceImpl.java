package org.javaboy.innovationschool.students;

import org.javaboy.innovationschool.trainings.TrainingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentsServiceImpl implements StudentsService{

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<StudentEntity> findAll() {

        List<StudentEntity> studentEntities = studentsRepository.findAll();
        if (studentEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The list of trainings is null.");
        }

        return studentsRepository.findAll();
    }

    @Override
    public Optional<StudentEntity> findById(Long id) {

        if (studentsRepository.findById(id).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The student with id " + id + " is not foumd.");
        }

        return studentsRepository.findById(id);
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {

        return studentsRepository.save(studentEntity);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {

        return studentsRepository.save(studentEntity);
    }

    @Override
    public Set<StudentEntity> findByName(String name) {

        Set<StudentEntity> studentEntities = studentsRepository.findByFirstNameStartingWithIgnoreCase(name);
        if (studentEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no student that starts with " + name);
        }

        return studentsRepository.findByFirstNameStartingWithIgnoreCase(name);
    }

    @Override
    public void deleteById(Long id) {

        Optional<StudentEntity> studentEntityOptional = studentsRepository.findById(id);

        if (studentEntityOptional.isPresent())
        {
            studentsRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id: " + id + " not found.");
        }
    }
}
