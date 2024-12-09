package org.javaboy.innovationschool.students;

import org.javaboy.innovationschool.students.commons.StudentMapper;
import org.javaboy.innovationschool.students.commons.StudentMapperNew;
import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentsRepository;
    private StudentMapperNew studentMapperNew;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository, StudentMapperNew studentMapperNew) {
        this.studentsRepository = studentsRepository;
        this.studentMapperNew = studentMapperNew;
    }

    @Override
    public List<StudentEntity> findAll() {

        List<StudentEntity> studentEntities = studentsRepository.findAllByDeletedAtIsNull();
        if (studentEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The list of trainings is null.");
        }

        return studentEntities;
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
    public Set<StudentEntity> findByName(String name) {

        Set<StudentEntity> studentEntities = studentsRepository.findByFirstNameStartingWithIgnoreCaseAndDeletedAtIsNull(name);
        if (studentEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no student that starts with " + name);
        }

        return studentsRepository.findByFirstNameStartingWithIgnoreCaseAndDeletedAtIsNull(name);
    }


    @Override
    public StudentEntity save(StudentEntity studentEntity) {

        studentEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        studentEntity.setCreatedBy(1L);
        studentEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        studentEntity.setUpdatedBy(1L);

        return studentsRepository.save(studentEntity);
    }


    @Override
    public StudentEntity update(StudentEntity studentEntity) {

        studentEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        studentEntity.setUpdatedBy(1L);     //s'kemi usera niher.

        return studentsRepository.save(studentEntity);
    }


    @Override
    public void deleteById(Long id) {

        Optional<StudentEntity> studentEntityOptional = studentsRepository.findById(id);

        if (studentEntityOptional.isPresent()) {
//          studentsRepository.deleteById(id);
            StudentEntity studentEntity = studentEntityOptional.get();

            studentEntity.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            studentEntity.setDeletedBy(1L);

            studentsRepository.save(studentEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id: " + id + " not found.");
        }
    }


    @Override
    public StudentDto partialUpdate(StudentDto studentDto, Long id) {

        Optional<StudentEntity> studentEntityOptional = studentsRepository.findById(id);

        if (studentEntityOptional.isPresent()) {

            StudentEntity studentEntity = studentEntityOptional.get();
//            StudentMapper.mapDtoToEntity(studentDto, studentEntity);
            studentMapperNew.mapDtoToEntity(studentDto, studentEntity);

            studentEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            studentEntity.setUpdatedBy(1L);

            StudentEntity patchedStudent = studentsRepository.save(studentEntity);

            return StudentMapper.mapEntityToDto(patchedStudent);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id: " + id + " not found.");
    }

}


//TODO: provo ma shume metoda ushtro, p.sh existsById();
//TODO: Lexo per mapStruct ma shume. Ushtrro pak, manipulo.
//TODO: Do far teorija boni download nga discord.