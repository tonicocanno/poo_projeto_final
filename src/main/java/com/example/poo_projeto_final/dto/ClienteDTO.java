package com.example.poo_projeto_final.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ClienteDTO {

    @NotBlank(message = "Por favor, insira o nome do cliente!")
    @Length(min=3, max=40, message = "NOME: [2-40] caracteres.")
    private String nome;
    @NotBlank(message = "Por favor, insira o CPF do cliente!")
    @Length(min=11, max=11, message = "CPF: [11] digitos.")
    private String cpf;
    @NotBlank(message = "Por favor, insira o endereço do cliente!")
    @Length(min=4, max=100, message = "ENDEREÇO: [4-100] caracteres.")
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
