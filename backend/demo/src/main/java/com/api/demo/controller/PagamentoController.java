package com.api.demo.controller;
import com.api.demo.services.AlunoServices;
import com.api.demo.services.PagamentoServices;
import org.hibernate.query.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.demo.model.Pagamento;
import java.util.List;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoServices pagamentoServices;

    public PagamentoController(PagamentoServices pagamentoServices){
        this.pagamentoServices = pagamentoServices;
    }

    @GetMapping("/")
    public List<Pagamento> findAll(){
        return pagamentoServices.findAll();
    }

    @GetMapping("/{id}")
    public Pagamento findById(
            @PathVariable Long id
    ){
        return pagamentoServices.findById(id);
    }

    @PostMapping("/")
    public Pagamento save(
            @RequestBody Pagamento pagamento
    ){
        return pagamentoServices.save(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento update(
            @PathVariable Long id,
            @RequestBody Pagamento pagamento
    ){
        return pagamentoServices.update(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        pagamentoServices.delete(id);
    }
}