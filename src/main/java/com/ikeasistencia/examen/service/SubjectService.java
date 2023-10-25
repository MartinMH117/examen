package com.ikeasistencia.examen.service;

import com.ikeasistencia.examen.entity.Subject;
import com.ikeasistencia.examen.repository.SubjectRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository repository;

    // simulacion de llamado a base para catalogo de materias
    @PostConstruct
    public void loadData() {
        Subject subjectOne = new Subject();
        subjectOne.setName("Español");
        repository.save(subjectOne);
        Subject subjectTwo = new Subject();
        subjectTwo.setName("Matematicas");
        repository.save(subjectTwo);
        Subject subjectThree = new Subject();
        subjectThree.setName("Quimica");
        repository.save(subjectThree);
    }
}
