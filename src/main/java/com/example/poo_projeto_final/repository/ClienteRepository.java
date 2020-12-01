package com.example.poo_projeto_final.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.poo_projeto_final.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    private List<Cliente> clientes;
    private int proxCod = 0;

    @PostConstruct
    public void criarClientes() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        Cliente c4 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X, 99");
        c1.setCpf("31184759302");

        c2.setCodigo(2);
        c2.setNome("Maria");
        c2.setEndereco("Rua Y, 222");
        c2.setCpf("21182736528");

        c3.setCodigo(3);
        c3.setNome("Fernanda");
        c3.setEndereco("Rua Z, 44");
        c3.setCpf("31198752637");

        c4.setCodigo(4);
        c4.setNome("Pedro");
        c4.setEndereco("Rua A, 1001");
        c4.setCpf("47695815817");

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);

        proxCod = 5;

    }

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
