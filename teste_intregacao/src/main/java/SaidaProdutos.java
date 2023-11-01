public class SaidaProdutos {  
    private CadastroProdutos cadastroProdutos;  
  
    // Construtor  
    public SaidaProdutos(CadastroProdutos cadastroProdutos) {  
        this.cadastroProdutos = cadastroProdutos;  
    }  
  
    // Remove produtos do estoque  
    public boolean removerProdutos(int idProduto, int quantidade) {  
        Produto produto = cadastroProdutos.buscarProduto(idProduto);  
        if (produto != null && produto.getQuantidade() >= quantidade) {  
            produto.setQuantidade(produto.getQuantidade() - quantidade);  
            return true;  
        } else {  
            return false;  
        }  
    }  
}  
