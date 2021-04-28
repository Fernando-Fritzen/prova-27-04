package com.example.cinema.dao;

import com.example.cinema.factory.ConnectionFactory;
import com.example.cinema.persistence.model.Filme;
import com.example.cinema.persistence.model.Genero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmeDAO {


    private Connection connection;

    public FilmeDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }



    public List<Filme> listarFilme() {

        String sql = "select filme.*, genero.descricao as genero " +
                "from filme inner join genero " +
                "on filme.GeneroId = genero.idGenero " +
                "order by genero";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();

            List<Filme> list = new ArrayList<>();
            Map<Integer, Genero> map = new HashMap<>();

            while (rs.next()) {

                Genero genero = map.get(rs.getInt("GeneroId"));

                if(genero == null) {
                    genero = new Genero();
                    genero.setIdGenero(rs.getInt("GeneroId"));
                    genero.setDescricao(rs.getString("genero"));
                    map.put(rs.getInt("GeneroId"), genero);
                }


                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDuracao(rs.getString("duracao"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setGeneroId(rs.getInt("GeneroId"));
                filme.setGenero(genero);
                list.add(filme);
            }
            return list;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public void cadastraFilme(Filme filme) {
        String sql = "insert into filme" +
                " (titulo, duracao, sinopse, GeneroId) " +
                "values (?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);


            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDuracao());
            stmt.setString(3, filme.getSinopse());
            stmt.setInt(4, filme.getGeneroId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alteraFilme(Filme filme) {

        String sql = "update filme set titulo=?, duracao=?, sinopse=?," +
                "GeneroId=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDuracao());
            stmt.setString(3, filme.getSinopse());
            stmt.setInt(4, filme.getGeneroId());
            stmt.setInt(5, filme.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarFilme(Filme filme) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from filme where id=?");
            stmt.setInt(1, filme.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
