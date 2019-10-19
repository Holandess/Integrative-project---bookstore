/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItemPedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme.gmonteiro3
 */
public class ItemPedidoDAO {

    private static String url = "";
    private static String SERVIDOR = "localhost";
    private static String BASEDADOS = "lojainformatica";
    private static Connection conexao;
    private static String bduser = "root";
    private static String bdpass = "";

    
    /**Método para salvar o pedido. 

     * Pega os valores que foram solicitados para o pedido e salva no banco.

     * @author Guilherme Gomes

     * @param  p  - Conjunto de informações do pedido.

    
     * @return boolean 

     */
    
    public static boolean Salvar(ItemPedido p) {
        try {
            java.util.Date date = new Date();
            Object param = new java.sql.Timestamp(date.getTime());

            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO `lojainformatica`.`item_pedido`"
                    + "("
                    + "`idvenda`,"
                    + "`idproduto`,"
                    + "`qtd`,"
                    + "`valor`,"
                    + "`date_entered`)"
                    + "VALUES"
                    + "("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?);");

            comando.setInt(1, p.getIdVenda());
            comando.setInt(2, p.getIdProduto());
            comando.setInt(3, p.getQtd());
            comando.setFloat(4, p.getValor());
            comando.setObject(5, param);

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    /**Método para selecionar no banco itens do pedido 

     * Busca os itens do pedido, quantidade dos produtos e nome do produto

     * @author Guilherme Gomes

     * @param  from String  - ? .
     * 
     * @param  to String  -  ?.
    
     * @return ArrayList

     */
    
    
    

    public static ArrayList<ItemPedido> getReports(String from, String to) {
        
        ArrayList<ItemPedido> listaProdutos = new ArrayList<ItemPedido>();

        try {
            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("SELECT p.nome, p.categoria, sum(ip.qtd) as qtd,"
                    + " sum(ip.valor) as valor FROM item_pedido ip INNER JOIN"
                    + " produtos p ON(p.codproduto = ip.idproduto)"
                    + "WHERE ip.date_entered BETWEEN ? AND ?" 
                    + " GROUP BY p.nome, p.categoria");
            comando.setString(1, from);
            comando.setString(2, to);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                ItemPedido p = new ItemPedido();
                p.setQtd(rs.getInt("qtd"));
                p.setValor(rs.getFloat("valor"));
                p.setNomeproduto(rs.getString("nome"));
                p.setCategoriaproduto(rs.getString("categoria"));
                listaProdutos.add(p);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProdutos;
    }

}
