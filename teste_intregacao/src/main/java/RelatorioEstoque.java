public class RelatorioEstoque {  
    private CadastroProdutos cadastroProdutos;  
  
    // Construtor  
    public RelatorioEstoque(CadastroProdutos cadastroProdutos) {  
        this.cadastroProdutos = cadastroProdutos;  
    }  
  
    // Gera o relatório de estoque  
    public String gerarRelatorio() {  
        StringBuilder relatorio = new StringBuilder();  
        relatorio.append("RELATÓRIO DE ESTOQUE\n");  
        for (Produto produto : cadastroProdutos.getProdutos()) {  
            relatorio.append(produto.getNome()).append(": ").append(produto.getQuantidade()).append("\n");  
        }  
        return relatorio.toString();  
    }  
}  
