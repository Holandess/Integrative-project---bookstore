/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme.gmonteiro3
 */
public class VendasDAO {

    private static String url = "";
    private static String SERVIDOR = "localhost";
    private static String BASEDADOS = "lojainformatica";
    private static Connection conexao;
    private static String bduser = "root";
    private static String bdpass = "";

    
    /**Método para salvar venda no banco de dados 

     * Salva os dados da venda no banco de dados ao finalizar pagamento.

     * @author Guilherme Gomes

     * @param  v - informações da venda que será registrada
     
    
     * @return v.getIdVenda 

     */
    
    public static int Salvar(Venda v) {

        try {
            java.util.Date date = new Date();
            Object param = new java.sql.Timestamp(date.getTime());
            
            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO `lojainformatica`.`vendas`"
                    + "("
                    + "`valor`,"
                    + "`meiodepagamento`,"
                    + "`idcliente`,"
                    + "`date_entered`)"
                    + "VALUES"
                    + "("
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?);");

            comando.setDouble(1, v.getValorVenda());
            comando.setString(2, v.getMeioDePagamento());
            comando.setInt(3, v.getIdCliente());
            comando.setObject(4, param);

            int linhasAfetadas = comando.executeUpdate();
            
            PreparedStatement selectid = conexao.prepareStatement("SELECT LAST_INSERT_ID() as id");
            ResultSet rs = selectid.executeQuery();
            while (rs.next()) {
                
                v.setIdVenda(rs.getInt("id"));
                return v.getIdVenda();

            }
            
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v.getIdVenda();

    }

}
