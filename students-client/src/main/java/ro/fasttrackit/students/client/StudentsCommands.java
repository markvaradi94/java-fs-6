package ro.fasttrackit.students.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.students.client.model.Student;
import ro.fasttrackit.students.client.service.StudentService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class StudentsCommands {
    private final StudentService studentService;

    @ShellMethod("Print all students")
    void printAllStudents() {
        studentService.getAll()
                .forEach(System.out::println);
    }

    @ShellMethod("Get student by id")
    void getStudent() {
        System.out.println("Student id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(studentService.getById(id));
    }

    @ShellMethod("Add new student")
    void addStudent() {
        System.out.println(studentService.addStudent(Student.builder()
                .id(0)
                .name("Pista")
                .age(69)
                .build()));
    }
}
