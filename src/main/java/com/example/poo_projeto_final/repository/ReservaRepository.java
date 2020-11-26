package com.example.poo_projeto_final.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.example.poo_projeto_final.model.Reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaRepository {

    @Autowired
    ClienteRepository clienteRepositorio;

    @Autowired
    VeiculoRepository veiculoRepositorio;

    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private int proxCod = 1;

    public Optional<Reserva> getReservaPorNumero(int numero){
        for(Reserva aux : reservas){
            if(aux.getNumero() == numero){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Reserva salvar(int idCliente, int idVeiculo){
        Reserva aux = new Reserva();
        aux.setNumero(proxCod++);
        aux.setCliente(clienteRepositorio.getClientePorCodigo(idCliente).get());
        aux.setVeiculo(veiculoRepositorio.getVeiculoPorCodigo(idVeiculo).get());
        reservas.add(aux);
        return aux;
    }

}
