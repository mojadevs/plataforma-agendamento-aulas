package com.api.demo.mapper;

import com.api.demo.dto.instrutor.InstrutorUpdateDTO;
import com.api.demo.dto.pagamento.PagamentoCreateDTO;
import com.api.demo.dto.pagamento.PagamentoResponseDTO;
import com.api.demo.dto.pagamento.PagamentoUpdateDTO;
import com.api.demo.model.Instrutor;
import com.api.demo.model.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    @Mapping(source = "idAula", target = "aula.id")
    @Mapping(source = "gatewayId", target = "gateway_id")
    @Mapping(source = "valorPlataforma", target = "valor_plataforma")
    @Mapping(source = "valorInstrutor", target = "valor_instrutor")
    @Mapping(source = "metodoPagamento", target = "metodo_pagamento")
    @Mapping(source = "dataCriacao", target = "data_criacao")
    @Mapping(source = "dataConfirmacao", target = "data_confirmacao")
    Pagamento toEntity(PagamentoCreateDTO dto);
    @Mapping(source = "aula.id", target = "idAula")
    @Mapping(source = "gateway_id", target = "gatewayId")
    @Mapping(source = "valor_plataforma", target = "valorPlataforma")
    @Mapping(source = "valor_instrutor", target = "valorInstrutor")
    @Mapping(source = "metodo_pagamento", target = "metodoPagamento")
    @Mapping(source = "data_criacao", target = "dataCriacao")
    @Mapping(source = "data_confirmacao", target = "dataConfirmacao")
    PagamentoResponseDTO toDto(Pagamento pagamento);
    @Mapping(source = "idAula", target = "aula.id")
    @Mapping(source = "gatewayId", target = "gateway_id")
    @Mapping(source = "valorPlataforma", target = "valor_plataforma")
    @Mapping(source = "valorInstrutor", target = "valor_instrutor")
    @Mapping(source = "metodoPagamento", target = "metodo_pagamento")
    @Mapping(source = "dataCriacao", target = "data_criacao")
    @Mapping(source = "dataConfirmacao", target = "data_confirmacao")
    @Mapping(target = "aula", ignore = true)
    void updateEntityFromDTO(PagamentoUpdateDTO dto, @MappingTarget Pagamento pagamento);
}
