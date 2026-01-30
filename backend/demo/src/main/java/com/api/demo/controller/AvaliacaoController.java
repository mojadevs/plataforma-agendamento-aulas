package com.api.demo.controller;
import com.api.demo.services.AlunoServices;
import com.api.demo.services.AvaliacaoServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Avaliacao;
import java.util.List;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoServices avaliacaoServices;

    public AvaliacaoController(AvaliacaoServices avaliacaoServices){
        this.avaliacaoServices = avaliacaoServices;
    }

    @GetMapping("/")
    public List<Avaliacao> findAll(){
        return avaliacaoServices.findAll();
    }

    @GetMapping("/{id}")
    public Avaliacao findById(
            @PathVariable Long id
    ){
        return avaliacaoServices.findById(id);
    }

    @PostMapping("/")
    public Avaliacao save(
            @RequestBody Avaliacao avaliacao
    ){
        return avaliacaoServices.save(avaliacao);
    }

    @PutMapping("/{id}")
    public Avaliacao update(
            @PathVariable Long id,
            @RequestBody Avaliacao avaliacao
    ){
        return avaliacaoServices.update(id, avaliacao);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        avaliacaoServices.delete(id);
    }
}
