package com.api.demo.dto.avaliacao;

import com.api.demo.model.Aula;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class AvaliacaoCreateDTO {
    private Aula aula;
    private Integer nota;
    private String comentario;
    private LocalDate data_avaliacao;
}
