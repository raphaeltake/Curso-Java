package model.entities;

public class generos {
    private Integer id_genero;
    private String descricao;

    public generos() {
    }

    public generos(Integer id_genero, String descricao) {
        this.id_genero = id_genero;
        this.descricao = descricao;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
