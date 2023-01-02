package ro.fasttrackit.course6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.course6.dto.CourseDto;
import ro.fasttrackit.course6.dto.mapper.CourseMapper;
import ro.fasttrackit.course6.exception.ResourceNotFoundException;
import ro.fasttrackit.course6.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("courses")
public class CourseController {
    private final CourseMapper mapper;
    private final CourseService service;

    @GetMapping
    List<CourseDto> allCourses() {
        return mapper.toDto(service.getAllCourses());
    }

    @GetMapping("{courseId}")
    CourseDto courseById(@PathVariable Long courseId) {
        return mapper.toDto(service.getCourseById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find course with id: " + courseId)));
    }
}
