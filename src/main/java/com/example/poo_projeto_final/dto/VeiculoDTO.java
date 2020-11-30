package com.example.poo_projeto_final.dto;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.example.poo_projeto_final.model.Reserva;

import org.hibernate.validator.constraints.Length;

public class VeiculoDTO {
    @NotBlank(message = "Por favor, insira o modelo do veiculo!")
    @Length(min=3, max=20, message = "MODELO: [3-20] caracteres.")
    private String modelo;
    private float valorDiaria;
    
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
