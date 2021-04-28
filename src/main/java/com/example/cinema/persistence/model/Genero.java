package com.example.cinema.persistence.model;

public class Genero {

    private Integer idGenero;
    private String descricao;

    public Genero() {

    }

    public Genero(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
