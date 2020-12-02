package com.example.poo_projeto_final.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.example.poo_projeto_final.model.Cliente;
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
    
    public void removeVeiculo(Veiculo veiculo){
        for ( Reserva aux : reservas){
            if ( veiculo.getCodigo() == aux.getVeiculo().getCodigo()){
                //LOGICA PARA REMOVER DA RESERVA DO CLIENTE QUE RESERVAVA O VEICULO DELETADO
                Cliente cliente = clienteRepositorio.getClientePorCodigo(aux.getCliente().getCodigo()).get();
                cliente.getReservas().remove(aux);
                reservas.remove(aux);
            }
        }
    }

    public void removeCliente(Cliente cliente){
        for ( Reserva aux : reservas){
            if ( cliente.getCodigo() == aux.getVeiculo().getCodigo()){
                //LOGICA PARA REMOVER DA RESERVA DO VEICULO QUE ERA RESERVADO PELO CLIENTE DELETADO
                Veiculo veiculo = veiculoRepositorio.getVeiculoPorCodigo(aux.getCliente().getCodigo()).get();
                veiculo.getReservas().remove(aux);
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
