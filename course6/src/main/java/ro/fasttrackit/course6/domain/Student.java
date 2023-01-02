package ro.fasttrackit.course6.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;
import static java.util.Optional.ofNullable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    String name;
    int age;
    @OneToMany
    List<Course> courses;

    public Student(String name, int age, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.courses = ofNullable(courses)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }
}
