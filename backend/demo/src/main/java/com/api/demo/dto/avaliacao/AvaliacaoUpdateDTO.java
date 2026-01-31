package com.api.demo.dto.avaliacao;

import com.api.demo.model.Aula;

import java.time.LocalDate;

public class AvaliacaoUpdateDTO {
    private Long id;
    private Aula aula;
    private Integer nota;
    private String comentario;
    private LocalDate data_avaliacao;
}
