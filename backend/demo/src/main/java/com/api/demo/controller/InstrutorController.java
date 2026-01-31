package com.api.demo.controller;
import com.api.demo.dto.instrutor.InstrutorCreateDTO;
import com.api.demo.dto.instrutor.InstrutorResponseDTO;
import com.api.demo.dto.instrutor.InstrutorUpdateDTO;
import com.api.demo.services.AlunoServices;
import com.api.demo.services.InstrutorServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Instrutor;
import java.util.List;

@Controller
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorServices instrutorServices;

    public InstrutorController(InstrutorServices instrutorServices){
        this.instrutorServices = instrutorServices;
    }

    @GetMapping("/")
    public ResponseEntity<List<InstrutorResponseDTO>> findAll(){

        List<InstrutorResponseDTO> instrutorResponseDTOList =  instrutorServices.findAll();
        return ResponseEntity.ok(instrutorResponseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorResponseDTO> findById(
            @PathVariable Long id
    ){
        InstrutorResponseDTO instrutorResponseDTO = instrutorServices.findById(id);
        return ResponseEntity.ok(instrutorResponseDTO);
    }

    @PostMapping("/")
    public ResponseEntity<InstrutorResponseDTO> save(
            @RequestBody InstrutorCreateDTO dto
    ){
        InstrutorResponseDTO instrutorResponseDTO =  instrutorServices.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(instrutorResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorResponseDTO> update(
            @PathVariable Long id,
            @RequestBody InstrutorUpdateDTO dto
    ){
        InstrutorResponseDTO instrutorResponseDTO = instrutorServices.update(id, dto);
        return ResponseEntity.ok(instrutorResponseDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        instrutorServices.delete(id);
    }
}

