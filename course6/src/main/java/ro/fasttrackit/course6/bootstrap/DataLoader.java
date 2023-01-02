package ro.fasttrackit.course6.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.course6.domain.Course;
import ro.fasttrackit.course6.domain.Student;
import ro.fasttrackit.course6.exception.ResourceNotFoundException;
import ro.fasttrackit.course6.repository.CourseRepository;
import ro.fasttrackit.course6.repository.StudentRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        courseRepository.saveAll(List.of(
                new Course("Physics"),
                new Course("Astronomy"),
                new Course("Math"),
                new Course("Spanish")
        ));

        studentRepository.saveAll(List.of(
                new Student("Gyuri", 69, courseRepository.findAll()),
                new Student("Markuci", 33, List.of())
//                new Student("Beluci", 44, List.of(physics, math))
        ));
    }
}
