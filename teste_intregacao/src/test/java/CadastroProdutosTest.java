import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CadastroProdutosTest {

    private CadastroProdutos cadastro;
    private Produto p1, p2, p3;

    @Before
    public void setUp() {
        cadastro = new CadastroProdutos();
        p1 = mock(Produto.class);
        p2 = mock(Produto.class);
        p3 = mock(Produto.class);
        when(p1.getId()).thenReturn(1);
        when(p1.getNome()).thenReturn("Arroz");
        when(p1.getPreco()).thenReturn(10.0);
        when(p1.getQuantidade()).thenReturn(50);
        when(p2.getId()).thenReturn(2);
        when(p2.getNome()).thenReturn("Feijão");
        when(p2.getPreco()).thenReturn(5.0);
        when(p2.getQuantidade()).thenReturn(100);
        when(p3.getId()).thenReturn(3);
        when(p3.getNome()).thenReturn("Macarrão");
        when(p3.getPreco()).thenReturn(3.0);
        when(p3.getQuantidade()).thenReturn(200);
        cadastro.adicionarProduto(p1);
        cadastro.adicionarProduto(p2);
    }

    @Test
    public void testAdicionarProduto() {
        cadastro.adicionarProduto(p3);
        List<Produto> produtos = cadastro.getProdutos();
        assertEquals(Arrays.asList(p1, p2, p3), produtos);
    }

    @Test
    public void testBuscarProdutoExistente() {
        Produto produto = cadastro.buscarProduto(1);
        assertEquals(p1, produto);
    }

    @Test
    public void testBuscarProdutoInexistente() {
        Produto produto = cadastro.buscarProduto(3);
        assertEquals(null, produto);
    }

 

    @Test
    public void testAtualizarProdutoInexistente() {
        Produto novoP3 = new Produto(3, "Macarrão Integral", 4.0, 150);
        cadastro.atualizarProduto(novoP3);
        List<Produto> produtos = cadastro.getProdutos();
        assertEquals(Arrays.asList(p1, p2), produtos);
    }

    @Test
    public void testRemoverProdutoExistente() {
        cadastro.removerProduto(1);
        List<Produto> produtos = cadastro.getProdutos();
        assertEquals(Arrays.asList(p2), produtos);
    }

    @Test
    public void testRemoverProdutoInexistente() {
        cadastro.removerProduto(3);
        List<Produto> produtos = cadastro.getProdutos();
        assertEquals(Arrays.asList(p1, p2), produtos);
    }
}