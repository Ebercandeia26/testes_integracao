public class Main {  
    public static void main(String[] args) {  
        CadastroProdutos cadastro = new CadastroProdutos();  
        Produto p1 = new Produto(1, "Arroz", 15.99, 50);  
        Produto p2 = new Produto(2, "Feijão", 8.99, 30);  
        cadastro.adicionarProduto(p1);  
        cadastro.adicionarProduto(p2);  
  
        EntradaProdutos entrada = new EntradaProdutos(cadastro);  
        entrada.adicionarProdutos(1, 10);  
        entrada.adicionarProdutos(2, 5);  
  
        SaidaProdutos saida = new SaidaProdutos(cadastro);  
        boolean result = saida.removerProdutos(1, 20);  
        if (result) {  
            System.out.println("Produtos removidos do estoque com sucesso.");  
        } else {  
            System.out.println("Não foi possível remover produtos do estoque.");  
        }  
  
        RelatorioEstoque relatorio = new RelatorioEstoque(cadastro);  
        String relatorioStr = relatorio.gerarRelatorio();  
        System.out.println(relatorioStr);  
    }  
}  
