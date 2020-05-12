package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.respository.StudentRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/findallstudents")
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok().body(students);
    }

    @PostMapping("/createstudent")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok().body(studentRepository.save(student));
    }
}
