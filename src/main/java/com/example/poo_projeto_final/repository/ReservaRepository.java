package com.example.poo_projeto_final.repository;

import java.util.ArrayList;
import java.util.Optional;


import com.example.poo_projeto_final.model.Reserva;
import com.example.poo_projeto_final.model.Veiculo;

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

    public Reserva salvar(Reserva reserva, int idCliente, int idVeiculo){
        reserva.setNumero(proxCod++);
        reserva.setCliente(clienteRepositorio.getClientePorCodigo(idCliente).get());
        reserva.setVeiculo(veiculoRepositorio.getVeiculoPorCodigo(idVeiculo).get());
        reservas.add(reserva);
        return reserva;
    }
    
    public void remove(Veiculo veiculo){
        for ( Reserva aux : reservas){
            if ( veiculo.getCodigo() == aux.getVeiculo().getCodigo()){
                reservas.remove(aux);
            }
        }
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

}
