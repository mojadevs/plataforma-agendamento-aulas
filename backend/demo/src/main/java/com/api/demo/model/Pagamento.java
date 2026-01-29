package com.api.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    private String gateway_id;
    private String status;
    private Double valor_plataforma;
    private Double valor_instrutor;
    private String metodo_pagamento;
    private LocalDate data_criacao;
    private LocalDate data_confirmacao;

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public LocalDate getData_confirmacao() {
        return data_confirmacao;
    }

    public void setData_confirmacao(LocalDate data_confirmacao) {
        this.data_confirmacao = data_confirmacao;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getGateway_id() {
        return gateway_id;
    }

    public void setGateway_id(String gateway_id) {
        this.gateway_id = gateway_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetodo_pagamento() {
        return metodo_pagamento;
    }

    public void setMetodo_pagamento(String metodo_pagamento) {
        this.metodo_pagamento = metodo_pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValor_instrutor() {
        return valor_instrutor;
    }

    public void setValor_instrutor(Double valor_instrutor) {
        this.valor_instrutor = valor_instrutor;
    }

    public Double getValor_plataforma() {
        return valor_plataforma;
    }

    public void setValor_plataforma(Double valor_plataforma) {
        this.valor_plataforma = valor_plataforma;
    }
}
