public class EntradaProdutos {  
    private CadastroProdutos cadastroProdutos;  
  
    // Construtor  
    public EntradaProdutos(CadastroProdutos cadastroProdutos) {  
        this.cadastroProdutos = cadastroProdutos;  
    }  
  
    // Adiciona produtos ao estoque  
    public void adicionarProdutos(int idProduto, int quantidade) {  
        Produto produto = cadastroProdutos.buscarProduto(idProduto);  
        if (produto != null) {  
            produto.setQuantidade(produto.getQuantidade() + quantidade);  
        }  
    }  
}  
