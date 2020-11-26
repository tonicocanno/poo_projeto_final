package com.example.poo_projeto_final.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.poo_projeto_final.dto.ClienteDTO;
import com.example.poo_projeto_final.model.Cliente;
import com.example.poo_projeto_final.model.Reserva;
import com.example.poo_projeto_final.repository.ReservaRepository;
import com.example.poo_projeto_final.service.ClienteService;
import com.example.poo_projeto_final.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
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
    private VeiculoService veiculoService;

    @Autowired
    private ReservaRepository ReservaRepositorio;

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

    //NADA FEITO
    @PostMapping("/{idCliente}/veiculos/{idVeiculo}")
    public ResponseEntity<Reserva> salvarReserva(@PathVariable int idCliente, @PathVariable int idVeiculo){
        Reserva reserva = ReservaRepositorio.salvar(idCliente, idVeiculo);
        return ResponseEntity.ok(reserva);
    }

}
