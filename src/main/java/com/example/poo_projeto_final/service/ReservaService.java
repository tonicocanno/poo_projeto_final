package com.example.poo_projeto_final.service;

import java.util.Optional;

import com.example.poo_projeto_final.model.Reserva;
import com.example.poo_projeto_final.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService {
    
    @Autowired
    ReservaRepository repositorio;

    public Reserva getReservaPorNumero(int numero){
        Optional<Reserva> op = repositorio.getReservaPorNumero(numero);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }
}
