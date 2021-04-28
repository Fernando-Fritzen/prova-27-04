package com.example.cinema.dao;

import com.example.cinema.factory.ConnectionFactory;
import com.example.cinema.persistence.model.Filme;
import com.example.cinema.persistence.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private Connection connection;

    public GeneroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Genero> listaGeneros() {
        String sql = "select * from genero";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Genero> generos = new ArrayList<>();
            Genero genero;
            while (rs.next()) {

                genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setDescricao(rs.getString("descricao"));
                System.out.println("====================================");

                generos.add(genero);

            }
            return generos;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
