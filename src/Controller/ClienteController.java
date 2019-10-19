/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import DAO.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author guilherme.gmonteiro3
 */
public class ClienteController {

    /**
     * Método para salvar cliente
     *
     * Pega os valores do ClienteDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param p - Conjunto de informações do cliente.
     *
     *
     * @return boolean
     */
    public static boolean Salvar(Cliente p) {
        return ClienteDAO.Salvar(p);
    }

    /**
     * Método para Excluir cliente
     *
     * Usa os valores do ClienteDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param id - id do Cliente
     *
     *
     * @return boolean
     *
     */
    public static boolean Excluir(String id) {
        //FProduto p = new Produto();
        return ClienteDAO.Excluir(id);
    }

    /**
     * Método para Atualizar cliente
     *
     * Usa os valores do ClienteDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param p - Objeto cliente com todas as informaçoes preenchidas.
     *
     *
     * @return boolean
     */
    public static boolean Atualizar(Cliente p) {
        return ClienteDAO.atualizar(p);
    }

    /**
     * Método para buscar cliente
     *
     * Usa os valores do ClienteDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param busca String - valor a ser pesquisado.
     *
     *
     * @return ArrayList *
     */
    public static ArrayList<String[]> buscaCliente(String busca) {
        ArrayList<Cliente> clientes = ClienteDAO.buscaClientes(busca);
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("TESTE FOI");
            listaClientes.add(new String[]{Integer.toString(clientes.get(i).getId()), String.valueOf(clientes.get(i).getNome()), clientes.get(i).getCpf().toString(), String.valueOf(clientes.get(i).getEmail())});

        }

        return listaClientes;
    }

    /**
     * Método para buscar cliente pelo ID
     *
     * Usa os valores do ClienteDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param id String - valor a ser pesquisado.
     *
     *
     * @return ArrayList *
     */
    public static ArrayList<Cliente> buscaClientePeloId(String id) {
        ArrayList<Cliente> clientes = ClienteDAO.buscaClientePeloId(id);

        return clientes;
    }

}
