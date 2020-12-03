package com.example.poo_projeto_final.dto;

import java.time.LocalDateTime;

import com.example.poo_projeto_final.model.Cliente;
import com.example.poo_projeto_final.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.hibernate.validator.constraints.Length;

public class ReservaDTO {

    private int numero;
    //IGNORAR CLIENTE "clientes/{idCliente}/reservas" (JsonIgnore)
    @JsonInclude(value = Include.NON_EMPTY)
    private Cliente cliente;
    //IGNORAR VEICULO "veiculos/{idVeiculo}/reservas" (JsonIgnore)
    @JsonInclude(value = Include.NON_EMPTY)
    private Veiculo veiculo;
    
    @Length(message = "Data deve ter o seguinte formato: 'dd/MM/yyyy@HH:mm:ss' ")
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm")
    private LocalDateTime inicioReserva;
    @Length(message = "Data deve ter o seguinte formato: 'dd/MM/yyyy@HH:mm:ss' ")
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm")
    private LocalDateTime fimReserva;

    private double valorTotal;

    public LocalDateTime getInicioReserva() {
        return inicioReserva;
    }

    public void setInicioReserva(LocalDateTime inicioReserva) {
            this.inicioReserva = inicioReserva;
    }

    public LocalDateTime getFimReserva() {
        return fimReserva;
    }

    public void setFimReserva(LocalDateTime fimReserva) {
        this.fimReserva = fimReserva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
