/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;

public class UsuarioController {

    /**
     * Método para Logar no sistema
     *
     * Usa valores do UsuarioDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param usuario String - valor usado para login
     * @param senha String - valor usado para login
     *
     * @return usuario, senha
     *
     */

    public static boolean Logar(String usuario, String senha) {
        return UsuarioDAO.logar(usuario, senha);
    }

}
