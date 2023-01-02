package ro.fasttrackit.course6.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record CourseDto(
        Long id,
        String name
) {
}
