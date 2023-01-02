package ro.fasttrackit.course6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.course6.domain.Student;
import ro.fasttrackit.course6.dto.CourseDto;
import ro.fasttrackit.course6.dto.StudentDto;
import ro.fasttrackit.course6.dto.mapper.CourseMapper;
import ro.fasttrackit.course6.dto.mapper.StudentMapper;
import ro.fasttrackit.course6.exception.ResourceNotFoundException;
import ro.fasttrackit.course6.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final StudentService service;

    @GetMapping
    List<StudentDto> allStudents() {
        return studentMapper.toDto(service.getAllStudents());
    }

    @GetMapping("{studentId}")
    StudentDto studentById(@PathVariable Long studentId) {
        return studentMapper.toDto(service.getStudentById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find student with id: " + studentId)));
    }

    @PostMapping
    StudentDto addStudent(@RequestBody Student student) {
        return studentMapper.toDto(service.addStudent(student));
    }

    @GetMapping("{studentId}/courses")
    List<CourseDto> studentCourses(@PathVariable Long studentId) {
        return courseMapper.toDto(service.getCoursesForStudent(studentId));
    }
}
