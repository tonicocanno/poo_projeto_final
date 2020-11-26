package com.example.poo_projeto_final.controller;

import com.example.poo_projeto_final.model.Reserva;
import com.example.poo_projeto_final.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/{numero}")
    public ResponseEntity<Reserva> getReservaPorNumero(@PathVariable int numero){
        return ResponseEntity.ok(reservaService.getReservaPorNumero(numero));
    }
}
