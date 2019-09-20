package br.prova;

public class Livro extends Produto{
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private Pessoa autor;
    private String editora;
    private int anoDePublicacao;
    // Métados Especiais


    public Livro(int id, String titulo) {
        super(id, titulo);
    }

    public Livro(int id, String titulo, Pessoa autor, String editora, int anoDePublicacao) {
        super(id, titulo);
        this.autor = autor;
        this.editora = editora;
        this.anoDePublicacao = anoDePublicacao;
    }

    // Métados Especiais Gets e Sets

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    // Métados

    @Override
    public String toString() {
        return "Livro{" +
                "autor=" + autor +
                ", editora='" + editora + '\'' +
                ", anoDePublicacao=" + anoDePublicacao +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
