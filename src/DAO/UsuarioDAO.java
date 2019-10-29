/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class UsuarioDAO {
    
    ArrayList<String> usuario = new ArrayList<>();
    
    

    public static boolean Salvar(Usuario u) {
        return SimulaDB.getInstance().SalvarUsuario(u);
    }

    

}
