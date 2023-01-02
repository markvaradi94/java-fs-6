package ro.fasttrackit.course6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.course6.domain.Course;
import ro.fasttrackit.course6.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return repository.findById(courseId);
    }
}
