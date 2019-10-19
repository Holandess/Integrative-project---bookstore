package Model;

import java.util.Random;

public class Venda {

    private int idVenda;
    private double valorVenda;
    private String meioDePagamento;
    private int idCliente;

    /**
     * Construtor Venda
     *
     * Recebe todos os dados da Venda
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param valorVenda double - Valor da venda
     *
     * @param meioDePagamento String - Meio do pagamento da venda
     *
     * @param idCliente int - id do Cliente
     *
     *
     *
     *
     */
    public Venda(double valorVenda, String meioDePagamento, int idCliente) {

        this.valorVenda = valorVenda;
        this.meioDePagamento = meioDePagamento;
        this.idCliente = idCliente;

    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(String meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
