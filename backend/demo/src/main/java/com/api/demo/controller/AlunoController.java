package com.api.demo.controller;
import com.api.demo.services.AlunoServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Aluno;
import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoServices alunoServices;

    public AlunoController(AlunoServices alunoServices){
        this.alunoServices = alunoServices;
    }

    @GetMapping("/")
    public List<Aluno> findAll(){
        return alunoServices.findAll();
    }

    @GetMapping("/{id}")
    public Aluno findById(
            @PathVariable Long id
    ){
        return alunoServices.findById(id);
    }

    @PostMapping("/")
    public void save(
            @RequestBody Aluno aluno
    ){
        alunoServices.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(
            @PathVariable Long id,
            @RequestBody Aluno aluno
    ){
        return alunoServices.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        alunoServices.delete(id);
    }
}

