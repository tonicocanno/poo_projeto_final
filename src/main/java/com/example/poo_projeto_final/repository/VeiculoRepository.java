package com.example.poo_projeto_final.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.poo_projeto_final.model.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository {
    
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    private static int proxCod = 1;

    public List<Veiculo> getTodosVeiculos(){
        return veiculos;
    }

    public Optional<Veiculo> getVeiculoPorCodigo(int codigo){
        for(Veiculo aux: veiculos){
            if(aux.getCodigo() == codigo){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public void remove(Veiculo veiculo){
        veiculos.remove(veiculo);
    }

    public Veiculo salvar(Veiculo veiculo){
        veiculo.setCodigo(proxCod++);
        veiculos.add(veiculo);
        return veiculo;
    }
}
