package com.api.demo.controller;
import com.api.demo.dto.pagamento.PagamentoCreateDTO;
import com.api.demo.dto.pagamento.PagamentoResponseDTO;
import com.api.demo.dto.pagamento.PagamentoUpdateDTO;
import com.api.demo.mapper.PagamentoMapper;
import com.api.demo.services.AlunoServices;
import com.api.demo.services.PagamentoServices;
import org.hibernate.query.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Pagamento;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoServices pagamentoServices;


    public PagamentoController(PagamentoServices pagamentoServices){
        this.pagamentoServices = pagamentoServices;
    }

    @GetMapping("/")
    public ResponseEntity<List<PagamentoResponseDTO>> findAll(){
        List<PagamentoResponseDTO> pagamentos = pagamentoServices.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> findById(
            @PathVariable Long id
    ){
        PagamentoResponseDTO pagamentoResponseDTO = pagamentoServices.findById(id);
        return ResponseEntity.ok(pagamentoResponseDTO);
    }

    @PostMapping("/")
    public ResponseEntity<PagamentoResponseDTO> save(
            @RequestBody PagamentoCreateDTO dto
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoServices.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> update(
            @PathVariable Long id,
            @RequestBody PagamentoUpdateDTO dto
            ){
        PagamentoResponseDTO pagamentoResponseDTO = pagamentoServices.update(id, dto);
        return ResponseEntity.ok(pagamentoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){
        pagamentoServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}