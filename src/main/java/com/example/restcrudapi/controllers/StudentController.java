package com.example.restcrudapi.controllers;

import com.example.restcrudapi.exceptions.StudentNotFoundException;
import com.example.restcrudapi.models.Student;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void loadStudentsData() {
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mateosz", "Murawiecki"));
        students.add(new Student("Anon", "Animoway"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        try {
            return students;
        } catch (NullPointerException ex) {
            return Collections.emptyList();
        }
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student;
        try {
            student = students.get(id);
        } catch (IndexOutOfBoundsException ex) {
            throw new StudentNotFoundException("Student not found for id: " + id);
        }
        return student;
    }
}
