package com.ikeasistencia.examen.service;

import com.ikeasistencia.examen.dto.StudentDTO;
import com.ikeasistencia.examen.entity.Student;
import com.ikeasistencia.examen.entity.Subject;
import com.ikeasistencia.examen.repository.StudentRepository;
import com.ikeasistencia.examen.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student save(StudentDTO studentDTO) {
        System.out.println(studentDTO);
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setPaternalSurname(studentDTO.getPaternalSurname());
        student.setMaternalSurname(studentDTO.getMaternalSurname());
        Subject subject = subjectRepository.findById(studentDTO.getIdSubject())
                .orElseThrow(() -> new EntityNotFoundException("Materia no encontrada"));
        student.setSubject(subject);
        return studentRepository.save(student);
    }
}
