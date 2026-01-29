package com.api.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Aula;
import java.util.List;

@Controller
@RequestMapping("/aulas")
public class AulaController {

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
            @RequestBody Aula aula
    ){
        //services.create(aula)
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody Aula aula
    ){
        // return services.update(id, aula);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        // services.delete(id);
    }
}

