/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author enzo.samorim
 */
public class Cliente {

    private int id;
    private String nome;
    private String email;
    private Long cpf;
    private String sexo;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private Long cep;
    private String cidade;
    private String uf;
    private Long telefone;
    private Long celular;

    /**
     * Construtor Cliente
     *
     * Recebe todos os dados do cliente
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param Nome String - Nome cliente
     *
     * @param email String - E-Mail Cliente
     *
     * @param cpf Long - CPF Cliente
     *
     * @param sexo String - Sexo Cliente
     *
     * @param endereco String - Endereco Cliente
     *
     * @param numero int - Numero de endereço
     *
     * @param complemento String - Complemento Endereço
     *
     * @param bairro String - Bairro Cliente
     *
     * @param cep Long - CEP Cliente
     *
     * @param cidade String - Cidade Cliente
     *
     * @param uf String - UF Cliente
     *
     * @param telefone Long - Telefone Cliente
     *
     * @param celular Long - Celular Cliente
     *
     *
     *
     */
    public Cliente(String Nome, String email, Long cpf, String sexo, String endereco, int numero, String complemento, String bairro, Long cep, String cidade, String uf, Long telefone, Long celular) {

        this.nome = Nome;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

}
