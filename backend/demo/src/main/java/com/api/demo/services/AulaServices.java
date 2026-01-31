package com.api.demo.services;
import com.api.demo.dto.aula.AulaCreateDTO;
import com.api.demo.dto.aula.AulaResponseDTO;
import com.api.demo.dto.aula.AulaUpdateDTO;
import com.api.demo.mapper.AulaMapper;
import com.api.demo.model.Aula;
import com.api.demo.repository.AulaRepository;

import java.util.ArrayList;
import java.util.List;

public class AulaServices {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    public AulaServices(AulaRepository aulaRepository, AulaMapper aulaMapper)
    {
        this.aulaRepository = aulaRepository;
        this.aulaMapper = aulaMapper;
    }

    public List<AulaResponseDTO> findAll(){
        List<Aula> aulas = aulaRepository.findAll();
        List<AulaResponseDTO> aulaResponseDTOList = new ArrayList<>();

        for(Aula aula : aulas){
            aulaResponseDTOList.add(aulaMapper.toDto(aula));
        }

        return aulaResponseDTOList;
    }

    public AulaResponseDTO findById(Long id){
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aula não encontrada");
        });

        AulaResponseDTO aulaResponseDTO = aulaMapper.toDto(aula);

        return aulaResponseDTO;
    }

    public void delete(long id){
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Aula não encontrada");
        });

        aulaRepository.delete(aula);
    }

    public AulaResponseDTO save(AulaCreateDTO dto){
        Aula aula = aulaMapper.toEntity(dto);
        return aulaMapper.toDto(aulaRepository.save(aula));
    }

    public AulaResponseDTO update(Long id, AulaUpdateDTO dto){
        Aula aula = aulaRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Aula não encontrado");
        });

        aulaMapper.updateEntityFromDTO(dto, aula);

        return aulaMapper.toDto(aulaRepository.save(aula));
    }
}
