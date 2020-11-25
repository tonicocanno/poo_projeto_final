package com.example.poo_projeto_final.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.poo_projeto_final.model.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository {
    
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    private static int proxCod;

    @PostConstruct
    public void criarVeiculos(){
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();
        Veiculo v3 = new Veiculo();
        Veiculo v4 = new Veiculo();

        v1.setCodigo(1);
        v1.setModelo("Chevrolet Onix");
        v1.setValorDiaria(138);

        v2.setCodigo(2);
        v2.setModelo("Jeep Renegade");
        v2.setValorDiaria(215);

        v3.setCodigo(3);
        v3.setModelo("Renault Duster Oroch");
        v3.setValorDiaria(248);

        v4.setCodigo(4);
        v4.setModelo("Chevrolet Cruze");
        v4.setValorDiaria(282);

        veiculos.add(v1);
        veiculos.add(v2);
        veiculos.add(v3);
        veiculos.add(v4);

        proxCod = 5;

    }

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

    public Veiculo atualizar(Veiculo veiculo){
        Veiculo aux = getVeiculoPorCodigo(veiculo.getCodigo()).get();

        if(aux != null){
            aux.setModelo(veiculo.getModelo());
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }

    public Veiculo salvar(Veiculo veiculo){
        veiculo.setCodigo(proxCod++);
        veiculos.add(veiculo);
        return veiculo;
    }
}
