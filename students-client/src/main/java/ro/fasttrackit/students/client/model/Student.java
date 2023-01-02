package ro.fasttrackit.students.client.model;

import lombok.Builder;

@Builder
public record Student(
        int id,
        String name,
        int age
) {
}
