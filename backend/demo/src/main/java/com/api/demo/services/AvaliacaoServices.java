package com.api.demo.services;
import com.api.demo.model.Avaliacao;
import com.api.demo.repository.AvaliacaoRepository;

import java.util.List;

public class AvaliacaoServices {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoServices(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> findAll(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(Long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Avaliacao não encontrada");
        });

        return avaliacao;
    }

    public void delete(long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Avaliacao não encontrada");
        });

        avaliacaoRepository.delete(avaliacao);
    }

    public Avaliacao save(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao update(Long id, Avaliacao avaliacao_update){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Avaliacao não encontrado");
        });

        avaliacao.setAula(avaliacao_update.getAula());
        avaliacao.setComentario(avaliacao.getComentario());
        avaliacao.setData_avaliacao(avaliacao_update.getData_avaliacao());
        avaliacao.setNota(avaliacao_update.getNota());

        return avaliacaoRepository.save(avaliacao);
    }
}
