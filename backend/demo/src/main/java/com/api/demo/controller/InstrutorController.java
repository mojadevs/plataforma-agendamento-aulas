package com.api.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Instrutor;
import java.util.List;

@Controller
@RequestMapping("/instrutores")
public class InstrutorController {

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
            @RequestBody Instrutor instrutor
    ){
        //services.create(instrutor)
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody Instrutor instrutor
    ){
        // return services.update(id, instrutor);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        // services.delete(id);
    }
}

