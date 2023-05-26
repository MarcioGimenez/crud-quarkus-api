package br.com.quarkus.api.services;

import br.com.quarkus.api.models.Produto;
import br.com.quarkus.api.repositories.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;
@Transactional
@ApplicationScoped
public class ProdutoService {
    @Inject
    private ProdutoRepository produtoRepository;

    public Produto cadastrar(Produto produto) {
        return produtoRepository.cadastrar(produto);
    }

    public Produto atualizar(Produto produto) {
        Produto produtoDB = Produto.findById(produto.id);
        produtoDB.setDescricao(produto.getDescricao());
        produtoDB.setValor(produto.getValor());
        produtoDB.setNome(produto.getNome());
        return produtoRepository.cadastrar(produtoDB);
    }

    public Optional<Produto> consultar(Long idProduto) {
        return produtoRepository.consultar(idProduto);
    }

    public void deletar(Long idProduto) {
        produtoRepository.deletar(idProduto);
    }
}
