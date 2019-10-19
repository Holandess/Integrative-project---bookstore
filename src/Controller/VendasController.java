/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendasDAO;
import Model.Venda;

/**
 *
 * @author guilherme.gmonteiro3
 */
public class VendasController {

    /**
     * Método para Salvar venda
     *
     * Usa valores do VendasDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param v - dados da venda
     *
     *
     * @return v
     *
     */
    public static int Salvar(Venda v) {

        return VendasDAO.Salvar(v);
    }

}
