package br.com.quarkus.api.repositories;

import br.com.quarkus.api.models.Produto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
@ApplicationScoped
public class ProdutoRepository {
    public Produto cadastrar(Produto produto) {
        produto.persist();
        return produto;
    }

    public Optional<Produto> consultar(Long idProduto) {
        return Produto.findByIdOptional(idProduto);
    }

    public void deletar(Long idProduto) {
        this.consultar(idProduto).ifPresent(Produto::delete);
    }
}
