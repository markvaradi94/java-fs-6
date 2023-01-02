package ro.fasttrackit.course6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.course6.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
