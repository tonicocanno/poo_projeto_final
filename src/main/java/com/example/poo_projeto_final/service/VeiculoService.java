package com.example.poo_projeto_final.service;

import java.util.List;
import java.util.Optional;

import com.example.poo_projeto_final.dto.VeiculoDTO;
import com.example.poo_projeto_final.model.Veiculo;
import com.example.poo_projeto_final.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VeiculoService {

    @Autowired
    private VeiculoRepository repositorio;
    
    public List<Veiculo> getTodosVeiculos(){
        return repositorio.getTodosVeiculos();
    }
    
    public Veiculo getVeiculoPorCodigo(int codigo){
        Optional <Veiculo> op = repositorio.getVeiculoPorCodigo(codigo);
        return op.orElseThrow(  () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo nao encontrado"));
    }

    public void removePorCodigo(int codigo){
        repositorio.remove(getVeiculoPorCodigo(codigo));
    }

    public Veiculo salvar(Veiculo veiculo){
        return repositorio.salvar(veiculo);
    }
}
