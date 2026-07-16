package model.entities;

public class Livros {
    private Integer id_livro;
    private String titulo;
    private Integer ano_publicacao;
    private Integer id_autor;
    private Integer id_editora;
    private Integer id_genero;

    public Livros() {
    }

    public Livros(Integer id_livro, String titulo, Integer ano_publicacao, Integer id_autor, Integer id_editora, Integer id_genero) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.ano_publicacao = ano_publicacao;
        this.id_autor = id_autor;
        this.id_editora = id_editora;
        this.id_genero = id_genero;
    }

    public Integer getId_livro() {
        return id_livro;
    }

    public void setId_livro(Integer id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public Integer getId_editora() {
        return id_editora;
    }

    public void setId_editora(Integer id_editora) {
        this.id_editora = id_editora;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }
}
