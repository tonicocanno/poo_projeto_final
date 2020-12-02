package com.example.poo_projeto_final.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.poo_projeto_final.dto.ReservaDTO;
import com.example.poo_projeto_final.model.Reserva;
import com.example.poo_projeto_final.model.Veiculo;
import com.example.poo_projeto_final.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService {
    
    @Autowired
    ReservaRepository repositorio;

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    ClienteService clienteService;

    public Reserva fromDTO(ReservaDTO reservaDTO){
        Reserva reserva = new Reserva();
        reserva.setInicioReserva(reservaDTO.getInicioReserva());
        reserva.setFimReserva(reservaDTO.getFimReserva());
        return reserva;
    }

    public Reserva getReservaPorNumero(int numero){
        Optional<Reserva> op = repositorio.getReservaPorNumero(numero);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }

    public Reserva salvar(Reserva reserva, int idCliente, int idVeiculo){
        veiculoService.getVeiculoPorCodigo(idVeiculo).addReserva(reserva);
        clienteService.getClientePorCodigo(idCliente).addReserva(reserva);
        return repositorio.salvar(reserva, idCliente, idVeiculo);
    }

    public void remove (Veiculo veiculo){
        repositorio.remove(veiculo);
    }

    public ReservaDTO toClienteDTO(Reserva reserva){
        ReservaDTO dto = new ReservaDTO();

        dto.setNumero(reserva.getNumero());
        dto.setInicioReserva(reserva.getInicioReserva());
        dto.setFimReserva(reserva.getFimReserva());
        dto.setVeiculo(reserva.getVeiculo());
        dto.setValorTotal(reserva.getValorTotal());
        
        return dto;
    }

    public ReservaDTO toVeiculoDTO(Reserva reserva){
        ReservaDTO dto = new ReservaDTO();

        dto.setNumero(reserva.getNumero());
        dto.setInicioReserva(reserva.getInicioReserva());
        dto.setFimReserva(reserva.getFimReserva());
        dto.setCliente(reserva.getCliente());
        dto.setValorTotal(reserva.getValorTotal());
        
        return dto;
    }

    public List<ReservaDTO> toClienteListDTO(List<Reserva> reservas){
        ArrayList<ReservaDTO> listDTO = new ArrayList<ReservaDTO>();

        for(Reserva aux: reservas){
            listDTO.add(toClienteDTO(aux));
        }
        return listDTO;
    }

    public List<ReservaDTO> toVeiculoListDTO(List<Reserva> reservas){
        ArrayList<ReservaDTO> listDTO = new ArrayList<ReservaDTO>();

        for(Reserva aux: reservas){
            listDTO.add(toVeiculoDTO(aux));
        }
        return listDTO;
    }
}
