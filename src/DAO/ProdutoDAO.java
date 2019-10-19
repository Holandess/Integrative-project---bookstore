/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
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
 * @author davi.msantos7
 */
public class ProdutoDAO {

    private static String url = "";
    private static String SERVIDOR = "localhost";
    private static String BASEDADOS = "lojainformatica";
    private static Connection conexao;
    private static String bduser = "root";
    private static String bdpass = "";

    
    /**Método para salvar produto no banco de dados 

     * Salva o produto no banco de dados ao cadastrar.

     * @author Guilherme Gomes

     * @param  p - informações do produto que será cadastrado
     
    
     * @return boolean

     */
    
    public static boolean Salvar(Produto p) {
        try {
            java.util.Date date = new Date();
            Object param = new java.sql.Timestamp(date.getTime());

            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO `lojainformatica`."
                    + "`produtos`" + "("
                    + "`categoria`,"
                    + "`nome`,"
                    + "`description`,"
                    + "`qtd`,"
                    + "`valor`,"
                    + "`date_entered`)"
                    + "VALUES"
                    + "(?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?);");

            comando.setString(1, p.getCategoria());
            comando.setString(2, p.getNomeProduto());
            comando.setString(3, p.getDescProduto());
            comando.setInt(4, p.getQtdProduto());
            comando.setFloat(5, p.getValorUnitario());
            comando.setObject(6, param);

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    /**Método para atualizar produto no banco de dados 

     * Atualizar/Editar o produto no banco de dados.

     * @author Guilherme Gomes

     * @param  p - informações do produto que será atualizado/editado
     
    
     * @return boolean

     */
    
    public static boolean atualizar(Produto p) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("UPDATE produtos SET categoria = ?, nome = ?, description = ?, qtd = ?, valor = ? WHERE codproduto = ?");

            comando.setString(1, p.getCategoria());
            comando.setString(2, p.getNomeProduto());
            comando.setString(3, p.getDescProduto());
            comando.setInt(4, p.getQtdProduto());
            comando.setFloat(5, p.getValorUnitario());
            comando.setInt(6, p.getcodProduto());

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    /**Método para excluir produto no banco de dados 

     * Exclui o produto no banco de dados ao selecionar excluir.

     * @author Guilherme Gomes

     * @param  id - id do produto que será excluido
     
    
     * @return boolean

     */
        public static boolean Excluir(String id) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM produtos WHERE codproduto = ?");

            comando.setString(1, id);

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
        
        /**Método para buscar produto no banco de dados 

     * Busca o produto no banco de dados pelo nome ou código do produto.

     * @author Guilherme Gomes

     * @param  busca String - nome ou codigo do produto.
     
    
     * @return ArrayList

     */

    public static ArrayList<Produto> buscaProdutos(String busca) {
        ArrayList<Produto> listaProdutos;
        listaProdutos = new ArrayList<Produto>();
        try {
            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("select * from produtos WHERE nome LIKE ? OR codproduto = ?");
            comando.setString(1, "%" + busca + "%");
            comando.setString(2, busca);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Produto p = new Produto(rs.getString("categoria"),
                        rs.getString("nome"),
                        rs.getString("description"),
                        rs.getInt("qtd"),
                        rs.getFloat("valor")
                );
                p.setcodProduto(rs.getInt("codproduto"));
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
