package com.api.demo.services;
import com.api.demo.dto.pagamento.PagamentoCreateDTO;
import com.api.demo.dto.pagamento.PagamentoResponseDTO;
import com.api.demo.dto.pagamento.PagamentoUpdateDTO;
import com.api.demo.mapper.PagamentoMapper;
import com.api.demo.model.Aluno;
import com.api.demo.model.Aula;
import com.api.demo.model.Instrutor;
import com.api.demo.model.Pagamento;
import com.api.demo.repository.AlunoRepository;
import com.api.demo.repository.AulaRepository;
import com.api.demo.repository.InstrutorRepository;
import com.api.demo.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoServices {

    private final PagamentoRepository pagamentoRepository;
    private final AulaRepository aulaRepository;

    private final PagamentoMapper pagamentoMapper;

    public PagamentoServices(PagamentoRepository pagamentoRepository, PagamentoMapper pagamentoMapper, AulaRepository aulaRepository){
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoMapper = pagamentoMapper;
        this.aulaRepository = aulaRepository;
    }

    public List<PagamentoResponseDTO> findAll(){
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        List<PagamentoResponseDTO> pagamentoResponseDTOList = new ArrayList<>();

        for(Pagamento pagamento : pagamentos){
            pagamentoResponseDTOList.add(pagamentoMapper.toDto(pagamento));
        }

        return pagamentoResponseDTOList;
    }

    public PagamentoResponseDTO findById(Long id){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Pagamento não encontrada");
        });

        PagamentoResponseDTO pagamentoResponseDTO = pagamentoMapper.toDto(pagamento);

        return pagamentoResponseDTO;
    }

    public void delete(long id){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Pagamento não encontrada");
        });

        pagamentoRepository.delete(pagamento);
    }

    public PagamentoResponseDTO save(PagamentoCreateDTO dto){
        Aula aula = aulaRepository.findById(dto.getIdAula())
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        Pagamento pagamento = pagamentoMapper.toEntity(dto);
        pagamento.setAula(aula);
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        PagamentoResponseDTO pagamentoResponseDTO = pagamentoMapper.toDto(pagamentoSalvo);

        return pagamentoResponseDTO;
    }


    public PagamentoResponseDTO update(Long id, PagamentoUpdateDTO dto){
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        pagamentoMapper.updateEntityFromDTO(dto, pagamento);

        Aula aula = aulaRepository.findById(dto.getIdAula())
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));
        pagamento.setAula(aula);


        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        return pagamentoMapper.toDto(pagamentoSalvo);
    }

}
