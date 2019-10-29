/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author enzo.samorim
 */
public class ItemPedido {

    private int id;
    private int idVenda;
    private int idProduto;
    private int qtd;
    private float valor;
    private String nomeproduto;
    private String categoriaproduto;

    /**
     * Construtor Item Pedido
     *
     * Recebe todos os dados do pedido
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param idVenda int - id do pedido
     *
     * @param idProduto int - id do produto
     *
     * @param qtd int - Quantidade produto
     *
     * @param valor float - Valor produto
     *
     *
     *
     */
    public ItemPedido(int idVenda, int idProduto, int qtd, float valor) {

        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtd = qtd;
        this.valor = valor;

    }

    public ItemPedido() {

    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getCategoriaproduto() {
        return categoriaproduto;
    }

    public void setCategoriaproduto(String categoriaproduto) {
        this.categoriaproduto = categoriaproduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

}
