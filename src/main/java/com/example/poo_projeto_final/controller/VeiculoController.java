package com.example.poo_projeto_final.controller;

import java.util.List;

import com.example.poo_projeto_final.dto.VeiculoDTO;
import com.example.poo_projeto_final.model.Veiculo;
import com.example.poo_projeto_final.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    VeiculoService veiculoService;

    @GetMapping()
    public List<Veiculo> getVeiculos(){
        return  veiculoService.getTodosVeiculos();
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
    
}
