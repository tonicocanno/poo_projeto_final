package com.example.poo_projeto_final.repository;

import java.util.List;
import java.util.Optional;

import com.example.poo_projeto_final.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    private List<Cliente> clientes;
    private int proxCod = 0;

    public List<Cliente> getTodosClientes(){
        return clientes;
    }

    public Optional<Cliente> getClientePorCodigo(int codigo){
        for(Cliente aux : clientes){
            if(aux.getCodigo() == codigo){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Cliente salvar(Cliente cliente){
        cliente.setCodigo(proxCod++);
        clientes.add(cliente);
        return cliente;
    }

    public void remove(Cliente cliente){
        clientes.remove(cliente);
    }

    public Cliente atualizar(Cliente cliente){

        Cliente aux = getClientePorCodigo(cliente.getCodigo()).get();

        if(aux != null){
            aux.setNome(cliente.getNome());
            aux.setEndereco(cliente.getEndereco());
            aux.setCpf(cliente.getCpf());
        }
        return aux;
    }
    
}
