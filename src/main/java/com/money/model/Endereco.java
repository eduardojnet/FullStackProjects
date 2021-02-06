package com.money.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String Complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    /**
     * Sets new logradouro.
     *
     * @param logradouro New value of logradouro.
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * Gets cidade.
     *
     * @return Value of cidade.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Gets numero.
     *
     * @return Value of numero.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets new bairro.
     *
     * @param bairro New value of bairro.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Sets new cep.
     *
     * @param cep New value of cep.
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Gets estado.
     *
     * @return Value of estado.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets new numero.
     *
     * @param numero New value of numero.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Gets logradouro.
     *
     * @return Value of logradouro.
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Sets new estado.
     *
     * @param estado New value of estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Gets bairro.
     *
     * @return Value of bairro.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Sets new cidade.
     *
     * @param cidade New value of cidade.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Gets cep.
     *
     * @return Value of cep.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Gets Complemento.
     *
     * @return Value of Complemento.
     */
    public String getComplemento() {
        return Complemento;
    }

    /**
     * Sets new Complemento.
     *
     * @param Complemento New value of Complemento.
     */
    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }
}
