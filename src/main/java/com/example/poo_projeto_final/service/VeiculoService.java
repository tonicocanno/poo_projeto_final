package com.example.poo_projeto_final.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.poo_projeto_final.dto.VeiculoDTO;
import com.example.poo_projeto_final.model.Veiculo;
import com.example.poo_projeto_final.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repositorio;

    public Veiculo fromDTO(VeiculoDTO dto){
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setValorDiaria(dto.getValorDiaria());
        return veiculo;
    }

    public VeiculoDTO toDTO(Veiculo veiculo){
        VeiculoDTO dto = new VeiculoDTO();
        dto.setModelo(veiculo.getModelo());
        dto.setValorDiaria(veiculo.getValorDiaria());
        return dto;
    }

    public List<VeiculoDTO> toListDTO(List<Veiculo> veiculos){
        ArrayList<VeiculoDTO> listDTO = new ArrayList<VeiculoDTO>();

        for(Veiculo aux: veiculos){
            listDTO.add(toDTO(aux));
        }
        return listDTO;
    }
    
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

    
    public Veiculo atualizar(Veiculo veiculo){
        getVeiculoPorCodigo(veiculo.getCodigo());
        return repositorio.atualizar(veiculo);
    }

    public Veiculo salvar(Veiculo veiculo){
        return repositorio.salvar(veiculo);
    }
}
