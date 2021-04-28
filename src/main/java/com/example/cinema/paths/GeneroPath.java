package com.example.cinema.paths;

import com.example.cinema.dao.FilmeDAO;
import com.example.cinema.dao.GeneroDAO;
import com.example.cinema.persistence.model.Filme;
import com.example.cinema.persistence.model.Genero;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/genero")
public class GeneroPath {
    @GET
    @Path("/listar")
    @Produces("application/json")
    public Response listaGeneros(){
        GeneroDAO generoDao = new GeneroDAO();
        List<Genero> generos = generoDao.listaGeneros();

        return Response.ok(new Gson().toJson(generos)).build();
    }

    @POST
    @Path("cadastra")
    @Consumes("application/json")
    @Produces("application/json")
    public Response criaGenero(Genero genero) {
        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.cadastraGenero(genero);
        return Response.ok(new Gson().toJson(genero)).build();
    }
}
