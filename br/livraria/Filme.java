package br.livraria;

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

        if(pessoa == null) return false;

        try {

            Pessoa pessoas[] = new Pessoa[this.getAtores().length+1];
            for (int i = 0; i < this.getAtores().length; i++) {
                if(!this.getAtores()[i].equals(pessoa) ){
                    pessoas[i] = this.getAtores()[i];
                }else{ return false; }
            }

            pessoas[this.getAtores().length] = pessoa;

            this.setAtores(pessoas);
            this.setQtdAtores(pessoas.length);

            return true;


        }catch (NullPointerException ex){

            Pessoa pessoas[] = new Pessoa[1];
            pessoas[0] = pessoa;

            this.setAtores(pessoas);
            this.setQtdAtores(pessoas.length);

            return true;


        }
    }

    public boolean temEssaPessoa(Pessoa pessoa){
        for(Pessoa pessoa1 : this.getAtores() ){
            if(pessoa1 != null && pessoa1.equals(pessoa)){
                return true;
            }
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
