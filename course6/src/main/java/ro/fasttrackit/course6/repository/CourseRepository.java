package ro.fasttrackit.course6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.course6.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
