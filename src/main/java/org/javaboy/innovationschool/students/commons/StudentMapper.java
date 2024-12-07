package org.javaboy.innovationschool.students.commons;

import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;

public class StudentMapper {

    public static void mapDtoToEntity(StudentDto studentDto, StudentEntity studentEntity) {

        if (studentDto.getId() != null) {       //bone edhe per blank qitu sahora.
            studentEntity.setId(studentDto.getId());
        }

        if (studentDto.getFirstName() != null) {
            studentEntity.setFirstName(studentDto.getFirstName());
        }

        if (studentDto.getLastName() != null) {
            studentEntity.setLastName(studentDto.getLastName());
        }

        if (studentDto.getEmail() != null) {
            studentEntity.setEmail(studentDto.getEmail());
        }

        if (studentDto.getPhoneNumber() != null) {
            studentEntity.setPhoneNumber(studentDto.getPhoneNumber());
        }

        if (studentDto.getProfilePicture() != null) {
            studentEntity.setProfilePicture(studentDto.getProfilePicture());
        }
    }


    public static StudentDto mapEntityToDto(StudentEntity studentEntity) {

        StudentDto studentDto = new StudentDto();

        studentDto.setId(studentEntity.getId());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setProfilePicture(studentEntity.getProfilePicture());
        studentDto.setPhoneNumber(studentEntity.getPhoneNumber());
        studentDto.setCreatedAt(studentEntity.getCreatedAt());
        studentDto.setCreatedBy(studentEntity.getCreatedBy());
        studentDto.setUpdatedAt(studentEntity.getUpdatedAt());
        studentDto.setUpdatedBy(studentEntity.getUpdatedBy());
        studentDto.setDeletedAt(studentEntity.getDeletedAt());
        studentDto.setDeletedBy(studentEntity.getDeletedBy());

        return studentDto;
    }

}
