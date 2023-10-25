package com.ikeasistencia.examen.controller;

import com.ikeasistencia.examen.entity.Grade;
import com.ikeasistencia.examen.repository.StudentRepository;
import com.ikeasistencia.examen.repository.SubjectRepository;
import com.ikeasistencia.examen.service.GradeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/student-{idStudent}/subject-{idSubject}")
    public ResponseEntity<Grade> save(
            @PathVariable Long idStudent,
            @PathVariable Long idSubject,
            @RequestBody Map<String, Double> request) {
        Grade grade = new Grade();
        grade.setGrade(request.get("number"));
        grade.setStudent(studentRepository.findById(idStudent).orElseThrow(
                () -> new EntityNotFoundException("Alumno no encontrado")));
        grade.setSubject(subjectRepository.findById(idSubject).orElseThrow(
                () -> new EntityNotFoundException("Materia no encontrada")));
        return ResponseEntity.ok(gradeService.save(grade));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Grade>> findAll() {
        return ResponseEntity.ok(gradeService.findAll());
    }
    @PutMapping("/update-{idGrade}")
    public ResponseEntity<Grade> update(
            @PathVariable Long idGrade,
            @RequestBody Map<String, Double> request) {
        Grade grade = gradeService.findById(idGrade);
        grade.setGrade(request.get("number"));
        return ResponseEntity.ok(gradeService.save(grade));
    }
    @DeleteMapping("/delete-{idGrade}")
    public ResponseEntity<String> delete(
            @PathVariable Long idGrade) {
        gradeService.delete(idGrade);
        return ResponseEntity.ok("Eliminado");
    }
}
