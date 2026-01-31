package com.api.demo.mapper;

import com.api.demo.dto.aula.AulaUpdateDTO;
import com.api.demo.dto.avaliacao.AvaliacaoCreateDTO;
import com.api.demo.dto.avaliacao.AvaliacaoResponseDTO;
import com.api.demo.dto.avaliacao.AvaliacaoUpdateDTO;
import com.api.demo.model.Aula;
import com.api.demo.model.Avaliacao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AvaliacaoMapper {
    Avaliacao toEntity(AvaliacaoCreateDTO dto);
    AvaliacaoResponseDTO toDto(Avaliacao avaliacao);
    void updateEntityFromDTO(AvaliacaoUpdateDTO dto, @MappingTarget Avaliacao avaliacao);
}
