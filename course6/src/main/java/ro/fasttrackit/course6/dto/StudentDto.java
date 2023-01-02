package ro.fasttrackit.course6.dto;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record StudentDto(
        Long id,
        String name,
        int age,
        List<CourseDto> courses
) {
}
