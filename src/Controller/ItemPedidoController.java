/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ItemPedidoDAO;
import Model.ItemPedido;
import java.util.ArrayList;

/**
 *
 * @author guilherme.gmonteiro3
 */
public class ItemPedidoController {

    /**
     * Método para salvar cliente
     *
     * Pega os valores do ItemPedidoDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param p - Conjunto de informações do pedido.
     *
     *
     * @return p
     */
    public static boolean Salvar(ItemPedido p) {

        return ItemPedidoDAO.Salvar(p);
    }

    public static ArrayList<String[]> getReports(String from, String to) {
        ArrayList<ItemPedido> produtos = ItemPedidoDAO.getReports(from, to);
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {

            listaProdutos.add(new String[]{produtos.get(i).getNomeproduto(), produtos.get(i).getCategoriaproduto(), String.valueOf(produtos.get(i).getQtd()), String.valueOf(produtos.get(i).getValor())});

        }
        return listaProdutos;
    }

}
