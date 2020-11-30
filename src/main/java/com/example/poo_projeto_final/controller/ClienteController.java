package com.example.poo_projeto_final.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.OnMessage;

import com.example.poo_projeto_final.dto.ClienteDTO;
import com.example.poo_projeto_final.dto.ReservaDTO;
import com.example.poo_projeto_final.model.Cliente;
import com.example.poo_projeto_final.model.Reserva;
import com.example.poo_projeto_final.service.ClienteService;
import com.example.poo_projeto_final.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping()
    public List<Cliente> getClientes() {
        return clienteService.getTodosClientes();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        clienteService.removePorCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@RequestBody ClienteDTO clienteDTO, @PathVariable int codigo) {
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setCodigo(codigo);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClientePorCodigo(@PathVariable int codigo){
        Cliente cliente = clienteService.getClientePorCodigo(codigo);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody ClienteDTO clienteDTO, HttpServletRequest request, UriComponentsBuilder builder){
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        Cliente novoCliente = clienteService.salvar(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novoCliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    //POST PARA CRIAÇÃO DE UMA NOVA RESERVA
    @PostMapping("/{idCliente}/veiculos/{idVeiculo}")
    public ResponseEntity<Reserva> salvarReserva(@RequestBody ReservaDTO reservaDTO, @PathVariable int idCliente, @PathVariable int idVeiculo){
        Reserva reserva = reservaService.fromDTO(reservaDTO);
            //DOMINGO -- VALIDATION
            if(reserva.getInicioReserva().getDayOfWeek().equals(DayOfWeek.SUNDAY) || 
            reserva.getFimReserva().getDayOfWeek().equals(DayOfWeek.SUNDAY) )
            //MAIOR DATA SISTEMA -- VALIDATION
                if(reserva.getInicioReserva().isBefore(LocalDateTime.now() )
            //DATA FIM > DATA INICIO -- VALIDATION
                    if(reserva.getFimReserva().isBefore(reserva.getInicioReserva()))
             return  ResponseEntity.badRequest().build();
        else{
        Reserva novoReserva = reservaService.salvar(reserva, idCliente, idVeiculo);
        return new ResponseEntity<Reserva>(novoReserva, HttpStatus.CREATED);
        }
    }

}
