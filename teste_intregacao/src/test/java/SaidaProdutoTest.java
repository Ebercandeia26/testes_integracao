
import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

public class SaidaProdutoTest {

    @Test
    public void testRemoverProdutosQuandoProdutoExisteEQuantidadeSuficiente() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        Produto produtoExistenteMock = mock(Produto.class);
        SaidaProdutos saida = new SaidaProdutos(cadastroMock);

        
        when(cadastroMock.buscarProduto(1)).thenReturn(produtoExistenteMock);
        when(produtoExistenteMock.getQuantidade()).thenReturn(50);

        boolean resultado = saida.removerProdutos(1, 10);

       
        verify(cadastroMock).buscarProduto(1);
        verify(produtoExistenteMock).setQuantidade(40);
        assertTrue(resultado);

    @Test
    public void testRemoverProdutosQuandoProdutoNaoExiste() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        SaidaProdutos saida = new SaidaProdutos(cadastroMock);

        when(cadastroMock.buscarProduto(1)).thenReturn(null);

        boolean resultado = saida.removerProdutos(1, 10);

        verify(cadastroMock).buscarProduto(1);
        assertFalse(resultado);
    }

    @Test
    public void testRemoverProdutosComQuantidadeNegativa() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        SaidaProdutos saida = new SaidaProdutos(cadastroMock);

        boolean resultado = saida.removerProdutos(1, -10);

        verify(cadastroMock, only()).buscarProduto(anyInt());
        assertFalse(resultado);
    }

    @Test
    public void testRemoverProdutosComIDInvalido() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        SaidaProdutos saida = new SaidaProdutos(cadastroMock);
        Produto produtoInvalidoMock = mock(Produto.class);

        when(cadastroMock.buscarProduto(0)).thenReturn(produtoInvalidoMock);

        boolean resultado = saida.removerProdutos(0, 10);

        verify(cadastroMock).buscarProduto(0);
        assertFalse(resultado);
    }

    @Test
    public void testRemoverProdutosComQuantidadeZero() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        SaidaProdutos saida = new SaidaProdutos(cadastroMock);

        boolean resultado = saida.removerProdutos(1, 0);

        verify(cadastroMock, only()).buscarProduto(anyInt());
        assertFalse(resultado);
    }
}
