package com.api.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Aluno;
import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

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
            @RequestBody Aluno aluno
    ){
        //services.create(aluno)
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody Aluno aluno
    ){
        // return services.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        // services.delete(id);
    }
}

