package com.example.cinema.paths;

import com.example.cinema.dao.FilmeDAO;
import com.example.cinema.persistence.model.Filme;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filme")
public class FilmePath {


    @GET
    @Path("/listar")
    @Produces("application/json")
    public Response listaFilmes(){
        FilmeDAO filmeDao = new FilmeDAO();
        List<Filme> filmes = filmeDao.listarFilme();

        return Response.ok(new Gson().toJson(filmes)).build();
   }

    @POST
    @Path("cadastra")
    @Consumes("application/json")
    @Produces("application/json")
    public Response criaFilme(Filme filme) {
        FilmeDAO filmeDAO = new FilmeDAO();
        filmeDAO.cadastraFilme(filme);
        return Response.ok(new Gson().toJson(filme)).build();
    }


}
