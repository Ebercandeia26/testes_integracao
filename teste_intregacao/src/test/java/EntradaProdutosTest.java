import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class EntradaProdutosTest {

    @Test
    public void testAdicionarProdutosQuandoProdutoExiste() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        Produto produtoExistenteMock = mock(Produto.class);
        EntradaProdutos entrada = new EntradaProdutos(cadastroMock);

        when(cadastroMock.buscarProduto(1)).thenReturn(produtoExistenteMock);
        when(produtoExistenteMock.getQuantidade()).thenReturn(50);

        entrada.adicionarProdutos(1, 10);

        verify(cadastroMock).buscarProduto(1);
        verify(produtoExistenteMock).setQuantidade(60);
    }

    @Test
    public void testAdicionarProdutosQuandoProdutoNaoExiste() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        EntradaProdutos entrada = new EntradaProdutos(cadastroMock);

        when(cadastroMock.buscarProduto(1)).thenReturn(null);

        entrada.adicionarProdutos(1, 10);

        verify(cadastroMock).buscarProduto(1);
        verifyNoMoreInteractions(cadastroMock);
    }

    @Test
    public void testAdicionarProdutosComQuantidadeNegativa() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        EntradaProdutos entrada = new EntradaProdutos(cadastroMock);

        entrada.adicionarProdutos(1, -10);

        verify(cadastroMock, never()).adicionarProduto(any(Produto.class));
        verify(cadastroMock, never()).atualizarProduto(any(Produto.class));
    }
    @Test
    public void testAdicionarProdutosComIDInvalido() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        EntradaProdutos entrada = new EntradaProdutos(cadastroMock);
        Produto produtoInvalidoMock = mock(Produto.class);

        when(cadastroMock.buscarProduto(0)).thenReturn(produtoInvalidoMock);

        entrada.adicionarProdutos(0, 10);

        verify(cadastroMock).buscarProduto(0);
        verifyNoMoreInteractions(cadastroMock);
    }

   @Test
    public void testAdicionarProdutosComQuantidadeZero() {
        CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
        EntradaProdutos entrada = new EntradaProdutos(cadastroMock);

        entrada.adicionarProdutos(1, 0);

        verify(cadastroMock, never()).adicionarProduto(any(Produto.class));
        verify(cadastroMock, never()).atualizarProduto(any(Produto.class));
    }
}
