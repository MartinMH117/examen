package com.ikeasistencia.examen.service;

import com.ikeasistencia.examen.entity.Grade;
import com.ikeasistencia.examen.repository.GradeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }
    public Grade findById(Long id) {
        return gradeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Alumno no encontrado"));
    }
    public void delete(Long id) {
        gradeRepository.delete(gradeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Alumno no encontrado")));
    }
}
