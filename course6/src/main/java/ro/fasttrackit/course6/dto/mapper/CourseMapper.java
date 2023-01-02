package ro.fasttrackit.course6.dto.mapper;

import org.springframework.stereotype.Component;
import ro.fasttrackit.course6.domain.Course;
import ro.fasttrackit.course6.dto.CourseDto;

@Component
public class CourseMapper implements EntityMapper<Course, CourseDto> {
    @Override
    public CourseDto toDto(Course source) {
        return CourseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

    @Override
    public Course toEntity(CourseDto source) {
        return new Course(source.name());
    }
}
