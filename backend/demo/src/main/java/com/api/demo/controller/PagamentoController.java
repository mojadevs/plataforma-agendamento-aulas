package com.api.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Pagamento;
import java.util.List;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

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
            @RequestBody Pagamento pagamento
    ){
        //services.create(pagamento)
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody Pagamento pagamento
    ){
        // return services.update(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        // services.delete(id);
    }
}

