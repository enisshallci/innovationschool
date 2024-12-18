package org.javaboy.innovationschool.students.commons;

import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;

public class StudentMapper {

    public static void mapDtoToEntity(StudentDto source, StudentEntity target) {

        if (source == null) {
            return;
        }

        if (source.getId() != null) {
            target.setId(source.getId());
        }

        if (source.getFirstName() != null) {
            target.setFirstName(source.getFirstName());
        }

        if (source.getLastName() != null) {
            target.setLastName(source.getLastName());
        }

        if (source.getEmail() != null) {
            target.setEmail(source.getEmail());
        }

        if (source.getPhoneNumber() != null) {
            target.setPhoneNumber(source.getPhoneNumber());
        }

        if (source.getProfilePicture() != null) {
            target.setProfilePicture(source.getProfilePicture());
        }
    }


    public static StudentDto mapEntityToDto(StudentEntity studentEntity) {

        if (studentEntity == null) {
            return null;
        }

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
