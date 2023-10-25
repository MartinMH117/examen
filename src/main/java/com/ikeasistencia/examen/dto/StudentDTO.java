package com.ikeasistencia.examen.dto;

import com.ikeasistencia.examen.entity.Subject;
import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private Long idSubject;
}
