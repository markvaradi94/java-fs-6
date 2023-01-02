package ro.fasttrackit.course6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.course6.domain.Course;
import ro.fasttrackit.course6.domain.Student;
import ro.fasttrackit.course6.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return repository.findById(studentId);
    }

    public List<Course> getCoursesForStudent(Long studentId) {
        return getStudentById(studentId)
                .map(Student::getCourses)
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }
}
