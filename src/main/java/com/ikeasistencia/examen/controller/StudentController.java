package com.ikeasistencia.examen.controller;

import com.ikeasistencia.examen.dto.StudentDTO;
import com.ikeasistencia.examen.entity.Student;
import com.ikeasistencia.examen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> all = studentService.findAll();
        return ResponseEntity.ok(all);
    }
    @PostMapping("/sing-up")
    public ResponseEntity<Student> save(@RequestBody StudentDTO studentDTO) {
        Student student = studentService.save(studentDTO);
        return ResponseEntity.ok(student);
    }
}
