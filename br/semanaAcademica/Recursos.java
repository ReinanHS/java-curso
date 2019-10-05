package br.semanaAcademica;

public class Recursos {
    private int codigo;
    private String nome;
    private String descricao;
    private int quantitativo;

    public Recursos(int codigo, String nome, String descricao, int quantitativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantitativo = quantitativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantitativo() {
        return quantitativo;
    }

    public void setQuantitativo(int quantitativo) {
        this.quantitativo = quantitativo;
    }

    @Override
    public String toString() {
        return "Recursos{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantitativo=" + quantitativo +
                '}';
    }
}
