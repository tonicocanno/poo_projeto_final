package com.example.poo_projeto_final.service;

import java.util.List;
import java.util.Optional;

import com.example.poo_projeto_final.dto.ClienteDTO;
import com.example.poo_projeto_final.model.Cliente;
import com.example.poo_projeto_final.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repositorio;
    
    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEndereco(dto.getEndereco());
        cliente.setCpf(dto.getCpf());
        return cliente;
    }

    public List<Cliente> getTodosClientes(){
        return repositorio.getTodosClientes();
    }

    public Cliente getClientePorCodigo(int codigo){
        Optional<Cliente> op = repositorio.getClientePorCodigo(codigo);
        return op.orElseThrow(  ()-> 
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public void removePorCodigo(int codigo){
        repositorio.remove(getClientePorCodigo(codigo));
    }

    public Cliente salvar(Cliente cliente){
        return repositorio.salvar(cliente);
    }
}
