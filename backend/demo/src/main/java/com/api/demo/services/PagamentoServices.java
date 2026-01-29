package com.api.demo.services;
import com.api.demo.model.Pagamento;
import com.api.demo.repository.PagamentoRepository;

import java.util.List;

public class PagamentoServices {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServices(PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Long id){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Pagamento não encontrada");
        });

        return pagamento;
    }

    public void delete(long id){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Pagamento não encontrada");
        });

        pagamentoRepository.delete(pagamento);
    }

    public Pagamento save(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento update(Long id, Pagamento pagamento_update){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Pagamento não encontrado");
        });

        pagamento.setAula(pagamento_update.getAula());
        pagamento.setData_confirmacao(pagamento_update.getData_confirmacao());
        pagamento.setMetodo_pagamento(pagamento_update.getMetodo_pagamento());
        pagamento.setData_criacao(pagamento_update.getData_criacao());
        pagamento.setGateway_id(pagamento_update.getGateway_id());
        pagamento.setStatus(pagamento_update.getStatus());
        pagamento.setValor_instrutor(pagamento_update.getValor_instrutor());
        pagamento.setValor_plataforma(pagamento_update.getValor_plataforma());

        return pagamentoRepository.save(pagamento);
    }
}
