package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mngapi/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getAll(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "janusz");
        response.addCookie(cookie);

        return STUDENTS;
    }

    @PostMapping
    public void register(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping("{id}")
    public void register(@PathVariable Integer id) {
        System.out.println(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, Student student) {
        System.out.println(String.format("%s %s", id, student));
    }

}
