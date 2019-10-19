/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme.gmonteiro3
 */
public class ClienteDAO {

    private static String url = "";
    private static String SERVIDOR = "localhost";
    private static String BASEDADOS = "lojainformatica";
    private static Connection conexao;
    private static String bduser = "root";
    private static String bdpass = "";

    
    
     /**Método para salvar cliente 

     * Pega os valores do Cliente e passa para o banco de dados.

     * @author Guilherme Gomes

     * @param  Cliente p  - Conjunto de informações do cliente.

    
     * @return boolean 

     */
    
    public static boolean Salvar(Cliente p) {

        try {
            java.util.Date date = new Date();
            Object param = new java.sql.Timestamp(date.getTime());

            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO `lojainformatica`."
                    + "`clientes`(`nome`,`email`,`cpf`,`date_entered`,`sexo`,"
                    + "`endereco`,`numero`,`complemento`,`bairro`,`cep`,`cidade`,"
                    + "`uf`,`telefone`,`celular`)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            comando.setString(1, p.getNome());
            comando.setString(2, p.getEmail());
            comando.setLong(3, p.getCpf());
            comando.setObject(4, param);
            comando.setString(5, p.getSexo());
            comando.setString(6, p.getEndereco());
            comando.setInt(7, p.getNumero());
            comando.setString(8, p.getComplemento());
            comando.setString(9, p.getBairro());
            comando.setLong(10, p.getCep().intValue());
            comando.setString(11, p.getCidade());
            comando.setString(12, p.getUf());
            comando.setLong(13, Integer.valueOf(p.getTelefone().intValue()));
            comando.setLong(14, Integer.valueOf(p.getCelular().intValue()));

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    /**Método para atualizar os dados do cliente 

     * Atualiza os dados de cliente no banco de dados

     * @author Guilherme Gomes

     * @param  Cliente p  - Conjunto de informações do cliente.

    
     * @return boolean 

     */
    
    public static boolean atualizar(Cliente p) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            //Object param = new java.sql.Timestamp(date.getTime());
            PreparedStatement comando = conexao.prepareStatement("UPDATE clientes SET nome = ?,"
                    + " email = ?, cpf = ?, sexo = ?,"
                    + " endereco = ?, numero = ?,complemento = ?, bairro = ?, cep = ?,cidade = ?,"
                    + " uf = ?, telefone = ?, celular = ? WHERE id = ?");

            comando.setString(1, p.getNome());
            comando.setString(2, p.getEmail());
            comando.setString(3, p.getCpf().toString());
            // comando.setObject(4, param);
            comando.setString(4, p.getSexo());
            comando.setString(5, p.getEndereco());
            comando.setInt(6, p.getNumero());
            comando.setString(7, p.getComplemento());
            comando.setString(8, p.getBairro());
            comando.setInt(9, p.getCep().intValue());
            comando.setString(10, p.getCidade());
            comando.setString(11, p.getUf());
            comando.setInt(12, Integer.valueOf(p.getTelefone().intValue()));
            comando.setInt(13, Integer.valueOf(p.getCelular().intValue()));
            comando.setInt(14, p.getId());

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    
    /**Método para buscar os dados dos clientes  

     * Busca os dados do cliente do banco de dados.

     * @author Guilherme Gomes

     * @param  busca String  - Dados digitados para fazer a busca nome/cpf.

    
     * @return ArrayList 

     */

    public static ArrayList<Cliente> buscaClientes(String busca) {
        ArrayList<Cliente> listaClientes;
        listaClientes = new ArrayList<Cliente>();
        try {
            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("select * from clientes WHERE nome LIKE ? OR cpf = ?");
            comando.setString(1, "%" + busca + "%");
            comando.setString(2, busca);

            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                System.out.println("PASSEI VEZES");
                Cliente c = new Cliente(rs.getString("nome"),
                        rs.getString("email"),
                        Long.parseLong(rs.getString("cpf")),
                        rs.getString("sexo"),
                        rs.getString("endereco"),
                        Integer.parseInt(rs.getString("numero")),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        Long.parseLong(rs.getString("cep")),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        Long.parseLong(rs.getString("telefone")),
                        Long.parseLong(rs.getString("celular")));
                c.setId(rs.getInt("id"));
                listaClientes.add(c);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }
    
    
        /**Método para buscar o cliente pelo Id 

     * Busca o cliente no banco de dados pelo Id

     * @author Guilherme Gomes

     * @param  id String  - id do cliente.

    
     * @return ArrayList

     */
        public static ArrayList<Cliente> buscaClientePeloId(String id) {
        ArrayList<Cliente> listaClientes;
        listaClientes = new ArrayList<Cliente>();
        try {
            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("select * from clientes WHERE id = ?");
            comando.setString(1, id);

            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("nome"),
                        rs.getString("email"),
                        Long.parseLong(rs.getString("cpf")),
                        rs.getString("sexo"),
                        rs.getString("endereco"),
                        Integer.parseInt(rs.getString("numero")),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        Long.parseLong(rs.getString("cep")),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        Long.parseLong(rs.getString("telefone")),
                        Long.parseLong(rs.getString("celular")));
                c.setId(rs.getInt("id"));
                listaClientes.add(c);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }
        
        /**Método para Excluir cliente 

     * Exclui o cliente do banco de dados pelo id.

     * @author Guilherme Gomes

     * @param  id String  - id do cliente.

    
     * @return boolean 

     */

    public static boolean Excluir(String id) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASEDADOS;
            conexao = DriverManager.getConnection(url, bduser, bdpass);
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM clientes WHERE id = ?");

            comando.setString(1, id);

            int linhasAfetadas = comando.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

}
