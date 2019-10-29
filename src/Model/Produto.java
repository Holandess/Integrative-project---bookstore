package Model;

public class Produto {

    private int codProduto;
    private int qtdProduto;
    
    private String Categoria;
    private String nomeProduto;
    private String descProduto;
    private float valorUnitario;

    /**
     * Construtor Produto
     *
     * Recebe todos os dados do produto
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param Categoria String - Categoria do produto
     *
     * @param nomeProduto int - Nome do produto
     *
     * @param descProduto String - Descrição do produto
     *
     * @param qtdProduto int - Quantidade do produto
     *
     * @param valorUnitario float - Valor Unitario do produto
     *
     *
     *
     */
    public Produto(String Categoria, String nomeProduto, String descProduto, int qtdProduto, float valorUnitario) {

        this.Categoria = Categoria;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.qtdProduto = qtdProduto;
        this.valorUnitario = valorUnitario;
    }

    public Produto() {
    }

    public int getcodProduto() {
        return codProduto;
    }

    public void setcodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
