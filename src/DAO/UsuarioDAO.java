/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;

/**
 *
 * @author guilherme
 */
public class UsuarioDAO {

    public static boolean Salvar(Usuario u) {
        return SimulaDB.getInstance().SalvarUsuario(u);
    }

    public static boolean logar(String usuario, String senha) {
        return SimulaDB.getInstance().logar(usuario, senha);
    }

}
