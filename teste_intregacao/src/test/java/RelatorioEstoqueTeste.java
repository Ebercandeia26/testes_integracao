import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class RelatorioEstoqueTeste {
    @Test
public void testRemoverProdutosQuandoProdutoExisteEQuantidadeInsuficiente() {
    CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
    Produto produtoExistenteMock = mock(Produto.class);
    SaidaProdutos saida = new SaidaProdutos(cadastroMock);

    when(cadastroMock.buscarProduto(1)).thenReturn(produtoExistenteMock);
    when(produtoExistenteMock.getQuantidade()).thenReturn(5); // Disponível: 5, Tentativa de Remoção: 10

    boolean resultado = saida.removerProdutos(1, 10);

    verify(cadastroMock).buscarProduto(1);
    assertFalse(resultado);
    verify(produtoExistenteMock, never()).setQuantidade(anyInt());
}
@Test
public void testRemoverProdutosComQuantidadeRestanteZero() {
    CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
    Produto produtoExistenteMock = mock(Produto.class);
    SaidaProdutos saida = new SaidaProdutos(cadastroMock);

    when(cadastroMock.buscarProduto(1)).thenReturn(produtoExistenteMock);
    when(produtoExistenteMock.getQuantidade()).thenReturn(10);

    boolean resultado = saida.removerProdutos(1, 10);

    verify(cadastroMock).buscarProduto(1);
    verify(produtoExistenteMock).setQuantidade(0);
    assertTrue(resultado);
}
@Test
public void testRemoverProdutosComIDNegativo() {
    CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
    SaidaProdutos saida = new SaidaProdutos(cadastroMock);

    boolean resultado = saida.removerProdutos(-1, 5);

    verify(cadastroMock,only()).buscarProduto(anyInt());
    assertFalse(resultado);
}
@Test
public void testRemoverProdutosQuandoProdutoExisteMasNaoEstaDisponivel() {
    CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
    Produto produtoExistenteMock = mock(Produto.class);
    SaidaProdutos saida = new SaidaProdutos(cadastroMock);

    when(cadastroMock.buscarProduto(1)).thenReturn(produtoExistenteMock);
    when(produtoExistenteMock.getQuantidade()).thenReturn(0);

    boolean resultado = saida.removerProdutos(1, 5);

    verify(cadastroMock).buscarProduto(1);
    assertFalse(resultado);
    verify(produtoExistenteMock, never()).setQuantidade(anyInt());
}
@Test
public void testRemoverProdutosComQuantidadeExcedente() {
    CadastroProdutos cadastroMock = mock(CadastroProdutos.class);
    Produto produtoExistenteMock = mock(Produto.class);
    SaidaProdutos saida = new SaidaProdutos(cadastroMock);

    when(cadastroMock.buscarProduto(1)).thenReturn(produtoExistenteMock);
    when(produtoExistenteMock.getQuantidade()).thenReturn(5); // Disponível: 5, Tentativa de Remoção: 10

    boolean resultado = saida.removerProdutos(1, 10);

    verify(cadastroMock).buscarProduto(1);
    verify(produtoExistenteMock, never()).setQuantidade(anyInt());
    assertFalse(resultado);
}
}
