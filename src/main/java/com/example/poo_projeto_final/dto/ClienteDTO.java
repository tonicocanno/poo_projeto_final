package com.example.poo_projeto_final.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO {

    @NotBlank(message = "Por favor, insira o nome do cliente!")
    @Length(min=3, max=40, message = "NOME: [2-40] caracteres.")
    private String nome;
    @CPF
    @NotBlank(message = "Por favor, insira o CPF do cliente!")
    private long cpf;
    @NotBlank(message = "Por favor, insira o endereço do cliente!")
    @Length(min=4, max=100, message = "ENDEREÇO: [4-100] caracteres.")
    private String endereco;

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
    
}
