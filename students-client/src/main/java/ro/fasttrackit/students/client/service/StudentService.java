package ro.fasttrackit.students.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.students.client.model.Student;

import java.util.List;

@Service
public class StudentService {
    RestTemplate restTemplate = new RestTemplate();

    public Student getById(int studentId) {
        return restTemplate.getForObject("http://localhost:8080/students" + studentId, Student.class);
    }

    public List<Student> getAll() {
        return restTemplate.exchange(
                "http://localhost:8080/students",
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Student>>() {
                }
        ).getBody();
    }

    public Student addStudent(Student student) {
        return restTemplate.postForObject("http://localhost:8080/students", student, Student.class);
    }
}
