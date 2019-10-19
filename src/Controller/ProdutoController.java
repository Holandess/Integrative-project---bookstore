package Controller;

import DAO.ProdutoDAO;

import Model.Produto;
import java.util.ArrayList;

public class ProdutoController {

    /**
     * Método para salvar produto
     *
     * Pega os valores do ProdutoDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param p - Objeto Produto com as informaçoes preenchidas.
     *
     *
     * @return boolean
     */
    public static boolean Salvar(Produto p) {
        //FProduto p = new Produto();
        return ProdutoDAO.Salvar(p);
    }

    /**
     * Método para atualizar produto
     *
     * Pega os valores do ProdutoDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param p - Objeto Produto.
     *
     *
     * @return bollean
     */
    public static boolean Atualizar(Produto p) {
        return ProdutoDAO.atualizar(p);
    }

    /**
     * Método para excluir produto
     *
     * Pega os valores do ProdutoDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param id String - id do produto a ser excluido.
     *
     *
     * @return boolean 
     */
    public static boolean Excluir(String id) {
        //FProduto p = new Produto();
        return ProdutoDAO.Excluir(id);
    }

    /**
     * Método para buscar produto
     *
     * Pega os valores do ProdutoDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param busca String - valor usado para a busca
     *
     *
     * @return ArrayList
     */
    public static ArrayList<String[]> getProdutos(String busca) {
        ArrayList<Produto> produtos = ProdutoDAO.buscaProdutos(busca);
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {

            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getcodProduto()), produtos.get(i).getCategoria(), produtos.get(i).getNomeProduto(), String.valueOf(produtos.get(i).getDescProduto()), String.valueOf(produtos.get(i).getQtdProduto()), String.valueOf(produtos.get(i).getValorUnitario())});

        }
        return listaProdutos;
    }

    /**
     * Método para buscar produto pelo ID
     *
     * Pega os valores do ProdutoDAO.
     *
     * @author Guilherme Gomes/Enzo Amorim
     *
     * @param idProduto String - valor usado para a busca
     *
     *
     * @return Objeto Produto encontrado
     */
    public static Produto getProdutoById(String idProduto) {
        //FProduto p = new Produto();

        ArrayList<Produto> produtos = ProdutoDAO.buscaProdutos(idProduto);

        Produto p = new Produto();
        for (int i = 0; i < produtos.size(); i++) {

            p = produtos.get(i);

        }
        return p;

    }
}
