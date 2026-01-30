package com.api.demo.controller;
import com.api.demo.services.AlunoServices;
import com.api.demo.services.InstrutorServices;
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
    public List<Instrutor> findAll(){
        return instrutorServices.findAll();
    }

    @GetMapping("/{id}")
    public Instrutor findById(
            @PathVariable Long id
    ){
        return instrutorServices.findById(id);
    }

    @PostMapping("/")
    public Instrutor save(
            @RequestBody Instrutor instrutor
    ){
        return instrutorServices.save(instrutor);
    }

    @PutMapping("/{id}")
    public Instrutor update(
            @PathVariable Long id,
            @RequestBody Instrutor instrutor
    ){
        return instrutorServices.update(id, instrutor);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        instrutorServices.delete(id);
    }
}

