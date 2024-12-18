package org.javaboy.innovationschool.students.commons;

import org.javaboy.innovationschool.students.models.StudentDto;
import org.javaboy.innovationschool.students.models.StudentEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudentMapperNew {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToEntity(StudentDto source, @MappingTarget StudentEntity target);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapEntityToDto(StudentEntity source, @MappingTarget StudentDto target);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StudentDto mapEntityToDto(StudentEntity studentEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Set<StudentDto> mapEntitiesToDtos (Set<StudentEntity> sourceList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<StudentDto> mapEntitiesToDtos (List<StudentEntity> sourceList);

    // Custom method for mapping Page<TrainingEntity> to Page<TrainingDto>
    default Page<StudentDto> mapPageEntitiesToPageDtos(Page<StudentEntity> studentEntityPage) {
        return studentEntityPage.map((this::mapEntityToDto));
    }
}
