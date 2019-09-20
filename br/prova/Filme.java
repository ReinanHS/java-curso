package br.prova;

import java.util.Arrays;

public class Filme extends Produto {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private Pessoa[] atores;

    private String categoria;
    private String classificacao;
    private int qtdAtores = 0;
    // M�tados Especiais

    public Filme(int id, String titulo) {
        super(id, titulo);
    }

    public Filme(int id, String titulo, String categoria, String classificacao) {
        super(id, titulo);
        this.categoria = categoria;
        this.classificacao = classificacao;

        this.atores = new Pessoa[qtdAtores];
    }

    // M�tados Especiais Gets e Sets

    public Pessoa[] getAtores() {
        return atores;
    }

    public void setAtores(Pessoa[] atores) {
        this.atores = atores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getQtdAtores() {
        return qtdAtores;
    }

    public void setQtdAtores(int qtdAtores) {
        this.qtdAtores = qtdAtores;
    }

    // M�tados
    /**
     *
     * Essa � a fun��o respons�vel por fazer o cadastramento de um pessoa
     *
     * @param
     * @return Boolean
    */
    public boolean addAtores(Pessoa pessoa){

        /*
        *     [ L�gica para o cadastramento ]
        *
        * Se o vetor n�o foi inicializado eu inicializo ele com uma posi��o com o valor que foi passado pelo par�metro.
        * Caso o contr�rio eu crio mais uma posi��o no vetor e coloco o valor que foi passado como Par�metro na ultima posi��o.
        *
        */

        if(this.getQtdAtores() < this.getAtores().length){
            this.atores[this.getQtdAtores()] = pessoa;
            this.qtdAtores++;

            return true;
        }

        return false;

    }

    public boolean temEssaPessoa(Pessoa pessoa){
        if(this.getQtdAtores() > 0){

            for (int i = 0; i < this.getQtdAtores(); i++) {
                if(this.getAtores()[i].equals(pessoa)){
                    return true;
                }
            }

            return false;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "atores=" + Arrays.toString(atores) +
                ", categoria='" + categoria + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", qtdAtores=" + qtdAtores +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
