package model.entities;

public class Autores {
    private Integer id_autor;
    private String nome;
    private String nomeregistro;
    private Integer ano_nascimento;
    private String cidade_nascimento;
    private String estado_nascimento;
    private Integer ano_falecimento;
    private String cidade_falecimento;
    private String estado_falecimento;

    public Autores() {
    }

    public Autores(Integer id_autor, String nome, String nomeregistro, Integer ano_nascimento, String cidade_nascimento, String estado_nascimento, Integer ano_falecimento, String cidade_falecimento, String estado_falecimento) {
        this.id_autor = id_autor;
        this.nome = nome;
        this.nomeregistro = nomeregistro;
        this.ano_nascimento = ano_nascimento;
        this.cidade_nascimento = cidade_nascimento;
        this.estado_nascimento = estado_nascimento;
        this.ano_falecimento = ano_falecimento;
        this.cidade_falecimento = cidade_falecimento;
        this.estado_falecimento = estado_falecimento;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeregistro() {
        return nomeregistro;
    }

    public void setNomeregistro(String nomeregistro) {
        this.nomeregistro = nomeregistro;
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(Integer ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    public String getCidade_nascimento() {
        return cidade_nascimento;
    }

    public void setCidade_nascimento(String cidade_nascimento) {
        this.cidade_nascimento = cidade_nascimento;
    }

    public String getEstado_nascimento() {
        return estado_nascimento;
    }

    public void setEstado_nascimento(String estado_nascimento) {
        this.estado_nascimento = estado_nascimento;
    }

    public int getAno_falecimento() {
        return ano_falecimento;
    }

    public void setAno_falecimento(Integer ano_falecimento) {
        this.ano_falecimento = ano_falecimento;
    }

    public String getCidade_falecimento() {
        return cidade_falecimento;
    }

    public void setCidade_falecimento(String cidade_falecimento) {
        this.cidade_falecimento = cidade_falecimento;
    }

    public String getEstado_falecimento() {
        return estado_falecimento;
    }

    public void setEstado_falecimento(String estado_falecimento) {
        this.estado_falecimento = estado_falecimento;
    }
}
