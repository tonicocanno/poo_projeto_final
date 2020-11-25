package com.example.poo_projeto_final.dto;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;

import com.example.poo_projeto_final.model.Cliente;

import org.hibernate.validator.constraints.Length;

public class VeiculoDTO {
    @NotBlank(message = "Por favor, insira o modelo do veiculo!")
    @Length(min=3, max=20, message = "MODELO: [3-20] caracteres.")
    private String modelo;
    @NotBlank(message = "Por favor, insira o valor da diaria do veiculo!")
    private float valorDiaria;
    
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

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

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
    
}
