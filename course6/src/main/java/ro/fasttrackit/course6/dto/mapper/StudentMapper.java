package ro.fasttrackit.course6.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.fasttrackit.course6.domain.Student;
import ro.fasttrackit.course6.dto.StudentDto;

import java.util.ArrayList;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class StudentMapper implements EntityMapper<Student, StudentDto> {
    private final CourseMapper courseMapper;

    @Override
    public StudentDto toDto(Student source) {
        return StudentDto.builder()
                .id(source.getId())
                .age(source.getAge())
                .name(source.getName())
                .courses(courseMapper.toDto(ofNullable(source.getCourses())
                        .map(ArrayList::new)
                        .orElseGet(ArrayList::new)))
                .build();
    }

    @Override
    public Student toEntity(StudentDto source) {
        return new Student(source.name(), source.age(), courseMapper.toEntity(ofNullable(source.courses())
                .map(ArrayList::new)
                .orElseGet(ArrayList::new)));
    }
}
