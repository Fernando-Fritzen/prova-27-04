package com.example.cinema.paths;

import com.example.cinema.dao.FilmeDAO;
import com.example.cinema.persistence.model.Filme;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filme")
public class FilmePath {

    @GET
    @Path("oi")
//    @Produces("application/json")
    public Response oi () {
//        return Response.ok(new Gson().toJson("Meu deus, funcionou")).build();
        return Response.status(Response.Status.OK).entity("Hello World! Maldição desfeita").type(MediaType.APPLICATION_JSON_TYPE).build();
    }


    @GET
    @Path("/listar")
    @Produces("application/json")
    public Response listaFilmes(){
        FilmeDAO filmeDao = new FilmeDAO();
        List<Filme> filmes = filmeDao.listaFilmes();

        return Response.ok(new Gson().toJson(filmes)).build();
   }
}
