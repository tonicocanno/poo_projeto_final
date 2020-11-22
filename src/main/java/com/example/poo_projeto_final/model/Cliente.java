package com.example.poo_projeto_final.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cliente {
    private int codigo;
    private String nome;
    private long cpf;
    private String endereco;
    private LocalDateTime dataInicioReserva;
	private LocalDateTime dataFimReserva;

    private ArrayList<Veiculo> reservas = new ArrayList<Veiculo>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Veiculo> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Veiculo> reservas) {
        this.reservas = reservas;
    }

    public boolean addVeiculo(Veiculo veiculo){
        return reservas.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return reservas.remove(veiculo);
    }

    public LocalDateTime getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(LocalDateTime dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public LocalDateTime getDataFimReserva() {
        return dataFimReserva;
    }

    public void setDataFimReserva(LocalDateTime dataFimReserva) {
        this.dataFimReserva = dataFimReserva;
    }

}
