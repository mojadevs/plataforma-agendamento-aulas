package com.api.demo.services;
import com.api.demo.dto.avaliacao.AvaliacaoCreateDTO;
import com.api.demo.dto.avaliacao.AvaliacaoResponseDTO;
import com.api.demo.dto.avaliacao.AvaliacaoUpdateDTO;
import com.api.demo.mapper.AvaliacaoMapper;
import com.api.demo.model.Avaliacao;
import com.api.demo.repository.AvaliacaoRepository;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoServices {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoMapper avaliacaoMapper;

    public AvaliacaoServices(AvaliacaoRepository avaliacaoRepository, AvaliacaoMapper avaliacaoMapper){
        this.avaliacaoRepository = avaliacaoRepository;
        this.avaliacaoMapper = avaliacaoMapper;
    }

    public List<AvaliacaoResponseDTO> findAll(){
        List<Avaliacao> avaliacaoList = avaliacaoRepository.findAll();
        List<AvaliacaoResponseDTO> avaliacaoResponseDTOList = new ArrayList<>();

        for(Avaliacao avaliacao : avaliacaoList){
            avaliacaoResponseDTOList.add(avaliacaoMapper.toDto(avaliacao));
        }

        return avaliacaoResponseDTOList;
    }

    public AvaliacaoResponseDTO findById(Long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Avaliacao não encontrada");
        });

        AvaliacaoResponseDTO avaliacaoResponseDTO = avaliacaoMapper.toDto(avaliacao);

        return avaliacaoResponseDTO;
    }

    public void delete(long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Avaliacao não encontrada");
        });

        avaliacaoRepository.delete(avaliacao);
    }

    public AvaliacaoResponseDTO save(AvaliacaoCreateDTO dto){
        Avaliacao avaliacao = avaliacaoMapper.toEntity(dto);
        return avaliacaoMapper.toDto(avaliacao);
    }

    public AvaliacaoResponseDTO update(Long id, AvaliacaoUpdateDTO dto){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Avaliacao não encontrado");
        });

        avaliacaoMapper.updateEntityFromDTO(dto, avaliacao);

        return avaliacaoMapper.toDto(avaliacaoRepository.save(avaliacao));
    }
}
