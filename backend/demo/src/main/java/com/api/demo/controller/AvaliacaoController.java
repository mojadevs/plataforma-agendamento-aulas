package com.api.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Avaliacao;
import java.util.List;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @GetMapping("/")
    public void findAll(){
        //return services.findAll();
    }

    @GetMapping("/{id}")
    public void findById(
            @PathVariable Long id
    ){
        // return services.findById(id);
    }

    @PostMapping("/")
    public void create(
            @RequestBody Avaliacao avaliacao
    ){
        //services.create(avaliacao)
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody Avaliacao avaliacao
    ){
        // return services.update(id, avalicao);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        // services.delete(id);
    }
}

