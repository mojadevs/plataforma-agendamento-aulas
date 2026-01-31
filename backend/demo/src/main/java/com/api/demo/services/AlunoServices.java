package com.api.demo.services;

import com.api.demo.dto.aluno.AlunoCreateDTO;
import com.api.demo.dto.aluno.AlunoResponseDTO;
import com.api.demo.dto.aluno.AlunoUpdateDTO;
import com.api.demo.mapper.AlunoMapper;
import com.api.demo.model.Aluno;
import com.api.demo.repository.AlunoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class AlunoServices {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;
    private final PasswordEncoder passwordEncoder;

    public AlunoServices(AlunoRepository alunoRepository, AlunoMapper alunoMapper, PasswordEncoder passwordEncoder){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<AlunoResponseDTO> findAll(){
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoResponseDTO> alunoResponseDTOList = new ArrayList<>();

        for(Aluno aluno : alunos){
            alunoResponseDTOList.add(alunoMapper.toDto(aluno));
        }

        return alunoResponseDTOList;
    }

    public AlunoResponseDTO findById(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aluno não encontrado");
        });

        AlunoResponseDTO alunoResponseDTO = alunoMapper.toDto(aluno);

        return alunoResponseDTO;
    }

    public void delete(long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aluno não encontrado");
        });

        alunoRepository.delete(aluno);
    }

    public AlunoResponseDTO save(AlunoCreateDTO dto){
        Aluno aluno = alunoMapper.toEntity(dto);
        aluno.setSenha(passwordEncoder.encode(dto.getSenha()));
        return alunoMapper.toDto(alunoRepository.save(aluno));
    }

    public AlunoResponseDTO update(Long id, AlunoUpdateDTO dto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Aluno não encontrado");
        });

        alunoMapper.updateEntityFromDTO(dto, aluno);

        return alunoMapper.toDto(alunoRepository.save(aluno));
    }
}
