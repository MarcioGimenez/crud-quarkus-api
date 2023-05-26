package br.com.quarkus.api.resources;

import br.com.quarkus.api.models.Produto;
import br.com.quarkus.api.services.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("produto")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @Inject
    private ProdutoService produtoService;

    @POST
    public Response cadastrar(Produto produto) {
        produtoService.cadastrar(produto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{idProduto}")
    public Response atualizar(@PathParam(value = "idProduto") Long id, Produto produto) {
        produto.id = id;
        produtoService.atualizar(produto);
        return Response.ok().build();
    }

    @GET
    public Response consultar(@QueryParam(value = "idProduto") Long idProduto) {
        Optional<Produto> optionalProduto = produtoService.consultar(idProduto);
        if (optionalProduto.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok().entity(optionalProduto.get()).build();
    }

    @DELETE
    @Path("{idProduto}")
    public Response deletar(@PathParam(value = "idProduto") Long idProduto) {
        produtoService.deletar(idProduto);
        return Response.ok().build();
    }
}
