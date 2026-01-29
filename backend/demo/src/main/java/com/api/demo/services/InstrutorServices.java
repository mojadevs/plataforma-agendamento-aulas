package com.api.demo.services;
import com.api.demo.model.Instrutor;
import com.api.demo.repository.InstrutorRepository;

import java.util.List;

public class InstrutorServices {

    private final InstrutorRepository instrutorRepository;

    public InstrutorServices(InstrutorRepository instrutorRepository){
        this.instrutorRepository = instrutorRepository;
    }

    public List<Instrutor> findAll(){
        return instrutorRepository.findAll();
    }

    public Instrutor findById(Long id){
        Instrutor instrutor = instrutorRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Instrutor não encontrada");
        });

        return instrutor;
    }

    public void delete(long id){
        Instrutor instrutor = instrutorRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Instrutor não encontrada");
        });

        instrutorRepository.delete(instrutor);
    }

    public Instrutor save(Instrutor instrutor){
        return instrutorRepository.save(instrutor);
    }

    public Instrutor update(Long id, Instrutor instrutor_update){
        Instrutor instrutor = instrutorRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("instrutor não encontrado");
        });

        instrutor.setNome(instrutor_update.getNome());
        instrutor.setEmail(instrutor_update.getEmail());
        instrutor.setSenha(instrutor_update.getSenha());
        instrutor.setData_cadastro(instrutor_update.getData_cadastro());
        instrutor.setPreco_hora(instrutor_update.getPreco_hora());
        instrutor.setTelefone(instrutor_update.getTelefone());
        instrutor.setAtivo(instrutor_update.getAtivo());

        return instrutorRepository.save(instrutor);
    }
}
