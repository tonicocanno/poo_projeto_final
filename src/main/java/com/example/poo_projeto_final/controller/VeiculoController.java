package com.example.poo_projeto_final.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.poo_projeto_final.dto.VeiculoDTO;
import com.example.poo_projeto_final.model.Veiculo;
import com.example.poo_projeto_final.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    VeiculoService veiculoService;

    @GetMapping()
    public List<Veiculo> getVeiculos(){
        return  veiculoService.getTodosVeiculos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Veiculo> getVeiculoPorCodigo(@PathVariable int codigo){
        Veiculo veiculo = veiculoService.getVeiculoPorCodigo(codigo);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remove(@PathVariable int codigo){
        veiculoService.removePorCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Veiculo> atualizar(@RequestBody VeiculoDTO veiculoDTO, @PathVariable int codigo){
        Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
        veiculo.setCodigo(codigo);
        veiculo = veiculoService.atualizar(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Veiculo> salvar(@Valid @RequestBody VeiculoDTO veiculoDTO, HttpServletRequest request, UriComponentsBuilder builder){
        Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
        Veiculo novoVeiculo = veiculoService.salvar(veiculo);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novoVeiculo.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    
}
