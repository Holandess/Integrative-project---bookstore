/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author guilherme
 */
public class Usuario {

    private int id;
    private String login;
    private String senha;
    private String nomeCompleto;
    private String email;

    /**
     * Construtor Usuario
     *
     * Recebe todos os dados do usuario
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param login String - Login usuario
     *
     * @param senha String - Senha do usuario
     *
     * @param nomeCompleto String - Nome do usuario      *
     * @param email String - E-Mail do usuario
     *
     *
     *
     *
     */
    public Usuario(String login, String senha, String nomeCompleto, String email) {
        Random random = new Random();
        this.id = random.nextInt(1000) + 0;
        this.login = login;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
