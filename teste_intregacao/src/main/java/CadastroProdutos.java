import java.util.ArrayList;  
import java.util.List;  
  
public class CadastroProdutos {  
    private List<Produto> produtos;  
  
    // Construtor  
    public CadastroProdutos() {  
        this.produtos = new ArrayList<>();  
    }  
  
    // Adiciona um produto ao cadastro  
    public void adicionarProduto(Produto produto) {  
        produtos.add(produto);  
    }  
  
    // Busca um produto pelo ID  
    public Produto buscarProduto(int id) {  
        for (Produto produto : produtos) {  
            if (produto.getId() == id) {  
                return produto;  
            }  
        }  
        return null;  
    }  
  
    // Atualiza os dados de um produto  
    public void atualizarProduto(Produto produto) {  
        Produto prod = buscarProduto(produto.getId());  
        if (prod != null) {  
            prod.setNome(produto.getNome());  
            prod.setPreco(produto.getPreco());  
            prod.setQuantidade(produto.getQuantidade());  
        }  
    }  
  
    // Remove um produto do cadastro  
    public void removerProduto(int id) {  
        Produto prod = buscarProduto(id);  
        if (prod != null) {  
            produtos.remove(prod);  
        }  
    }  
  
    // Retorna a lista de produtos cadastrados  
    public List<Produto> getProdutos() {  
        return produtos;  
    }  
}  
