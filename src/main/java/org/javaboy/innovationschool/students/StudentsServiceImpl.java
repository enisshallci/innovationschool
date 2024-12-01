package org.javaboy.innovationschool.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return studentsRepository.findAll();
    }

    @Override
    public Optional<StudentEntity> findById(Long id) {

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

        return studentsRepository.findByFirstNameStartingWithIgnoreCase(name);
    }
}
