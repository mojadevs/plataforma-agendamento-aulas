package com.api.demo.services;
import com.api.demo.model.Aula;
import com.api.demo.repository.AulaRepository;

import java.util.List;

public class AulaServices {

    private final AulaRepository aulaRepository;

    public AulaServices(AulaRepository aulaRepository){
        this.aulaRepository = aulaRepository;
    }

    public List<Aula> findAll(){
        return aulaRepository.findAll();
    }

    public Aula findById(Long id){
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aula não encontrada");
        });

        return aula;
    }

    public void delete(long id){
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aula não encontrada");
        });

        aulaRepository.delete(aula);
    }

    public Aula save(Aula aula){
        return aulaRepository.save(aula);
    }

    public Aula update(Long id, Aula aula_update){
        Aula aula = aulaRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Aula não encontrado");
        });

        aula.setAluno(aula_update.getAluno());
        aula.setData_hora(aula_update.getData_hora());
        aula.setDuracao(aula_update.getDuracao());
        aula.setInstrutor(aula_update.getInstrutor());
        aula.setValor_total(aula_update.getValor_total());
        aula.setStatus(aula_update.getStatus());

        return aulaRepository.save(aula);
    }
}
