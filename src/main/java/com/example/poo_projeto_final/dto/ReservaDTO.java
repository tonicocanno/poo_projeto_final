package com.example.poo_projeto_final.dto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.poo_projeto_final.model.Cliente;
import com.example.poo_projeto_final.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservaDTO {
    private Cliente cliente;
    private Veiculo veiculo;
    
    @NotNull(message = "Por favor, insira uma data valida!")
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime inicioReserva;
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
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
    
}
