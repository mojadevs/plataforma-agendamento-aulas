package com.api.demo.dto.aula;

import com.api.demo.model.Aluno;
import com.api.demo.model.Instrutor;


import java.time.LocalDate;
import java.time.LocalTime;

public class AulaCreateDTO {
    private Aluno aluno;
    private Instrutor instrutor;
    private LocalDate data_hora;
    private LocalTime duracao;
    private String status;
    private Double valor_total;
}
