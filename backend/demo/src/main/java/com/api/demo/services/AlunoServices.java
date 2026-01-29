package com.api.demo.services;

import com.api.demo.model.Aluno;
import com.api.demo.repository.AlunoRepository;

import java.util.List;

public class AlunoServices {

    private final AlunoRepository alunoRepository;

    public AlunoServices(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aluno não encontrado");
        });

        return aluno;
    }

    public void delete(long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aluno não encontrado");
        });

        alunoRepository.delete(aluno);
    }

    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno_update){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Aluno não encontrado");
        });

        aluno.setNome(aluno_update.getNome());
        aluno.setEmail(aluno_update.getEmail());
        aluno.setSenha(aluno_update.getSenha());
        aluno.setTelefone(aluno_update.getTelefone());
        aluno.setData_cadastro(aluno_update.getData_cadastro());
        aluno.setAtivo(aluno_update.getAtivo());

        return alunoRepository.save(aluno);
    }
}
