package com.example.cinema.persistence.model;


public class Filme {

    private Integer id;
    private String titulo;
    private String duracao;
    private String sinopse;
    private int generoId;
    private Genero genero;

    public Filme() {

    }

    public Filme(String titulo, String duracao, String sinopse, int generoId, Genero genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.generoId = generoId;
        this.genero = genero;
    }

    public Filme(String titulo, String duracao, int generoId, String sinopse) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.generoId = generoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracao='" + duracao + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", generoId=" + generoId +
                ", genero=" + genero +
                '}';
    }
}
