package com.money.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private final String logradouro;
    private final String numero;
    private final String bairro;
    private final String cep;
    private final String cidade;
    private final String estado;

    public Endereco(String logradouro, String numero, String bairro, String cep, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getNumero() {
        return numero;
    }
}
