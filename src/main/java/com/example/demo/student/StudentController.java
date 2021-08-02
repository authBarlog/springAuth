package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final RequestCounter requestCounter;

    public StudentController(RequestCounter requestCounter) {
        this.requestCounter = requestCounter;
    }

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        requestCounter.increment();
        return STUDENTS.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
    }

    @GetMapping
    public int getCount() {
        return requestCounter.getRequestCount();
    }

}
