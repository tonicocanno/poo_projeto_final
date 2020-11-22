package com.example.poo_projeto_final.model;

import java.util.ArrayList;

public class Veiculo {
    private int codigo;
    private String modelo;
	private float valorDiaria;

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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

	public void setClientes(Cliente cliente) {
		clientes.add(cliente);
	}
}
