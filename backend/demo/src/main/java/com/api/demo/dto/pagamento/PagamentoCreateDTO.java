package com.api.demo.dto.pagamento;

import com.api.demo.model.Aula;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class PagamentoCreateDTO {
    private Aula aula;
    private String gateway_id;
    private String status;
    private Double valor_plataforma;
    private Double valor_instrutor;
    private String metodo_pagamento;
    private LocalDate data_criacao;
    private LocalDate data_confirmacao;
}
