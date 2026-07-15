package model.entities;

public class editoras {
    private Integer id_editora;
    private String nome;
    private String cidade_sede;
    private Integer ano_fundacao;

    public editoras() {
    }

    public editoras(Integer id_editora, String nome, String cidade_sede, Integer ano_fundacao) {
        this.id_editora = id_editora;
        this.nome = nome;
        this.cidade_sede = cidade_sede;
        this.ano_fundacao = ano_fundacao;
    }

    public Integer getId_editora() {
        return id_editora;
    }

    public void setId_editora(Integer id_editora) {
        this.id_editora = id_editora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade_sede() {
        return cidade_sede;
    }

    public void setCidade_sede(String cidade_sede) {
        this.cidade_sede = cidade_sede;
    }

    public Integer getAno_fundacao() {
        return ano_fundacao;
    }

    public void setAno_fundacao(Integer ano_fundacao) {
        this.ano_fundacao = ano_fundacao;
    }
}
