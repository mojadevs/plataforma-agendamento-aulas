package com.api.demo.controller;
import com.api.demo.services.AlunoServices;
import com.api.demo.services.AulaServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Aula;
import java.util.List;

@Controller
@RequestMapping("/aulas")
public class AulaController {

    private final AulaServices aulaServices;

    public AulaController(AulaServices aulaServices){
        this.aulaServices = aulaServices;
    }

    @GetMapping("/")
    public List<Aula> findAll(){return aulaServices.findAll();}

    @GetMapping("/{id}")
    public Aula findById(
            @PathVariable Long id
    ){
        return aulaServices.findById(id);
    }

    @PostMapping("/")
    public Aula save(
            @RequestBody Aula aula
    ){
        return aulaServices.save(aula);
    }

    @PutMapping("/{id}")
    public Aula update(
            @PathVariable Long id,
            @RequestBody Aula aula
    ){
        return aulaServices.update(id, aula);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        aulaServices.delete(id);
    }
}

