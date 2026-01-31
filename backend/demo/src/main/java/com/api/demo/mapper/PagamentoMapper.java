package com.api.demo.mapper;

import com.api.demo.dto.instrutor.InstrutorUpdateDTO;
import com.api.demo.dto.pagamento.PagamentoCreateDTO;
import com.api.demo.dto.pagamento.PagamentoResponseDTO;
import com.api.demo.model.Instrutor;
import com.api.demo.model.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    Pagamento toEntity(PagamentoCreateDTO dto);
    PagamentoResponseDTO toDto(Pagamento pagamento);
    void updateEntityFromDTO(InstrutorUpdateDTO dto, @MappingTarget Instrutor instrutor);
}
