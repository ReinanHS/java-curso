package br.livraria;

import java.util.Arrays;

public class CadastroDePessoa {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private Pessoa pessoa[];
    private int qtdPessoa;
    // Métados Especiais
    public CadastroDePessoa() { }

    public CadastroDePessoa(Pessoa[] pessoa, int qtdPessoa) {
        this.pessoa = pessoa;
        this.qtdPessoa = qtdPessoa;
    }

    // Métados Especiais Gets e Sets

    public Pessoa[] getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa[] pessoa) {
        this.pessoa = pessoa;
    }

    public int getQtdPessoa() {
        return qtdPessoa;
    }

    public void setQtdPessoa(int qtdPessoa) {
        this.qtdPessoa = qtdPessoa;
    }

    // Métados
    /**
     *
     * Essa é a função responsável por fazer o cadastramento de um pessoa
     *
     * @return Boolean
    */
    public boolean adicionarPessoa(Pessoa pessoa){

        /*
        *     [ Lógica para o cadastramento ]
        *
        * Se o vetor não foi inicializado eu inicializo ele com uma posição com o valor que foi passado pelo parâmetro.
        * Caso o contrário eu crio mais uma posição no vetor e coloco o valor que foi passado como Parâmetro na ultima posição.
        *
        */

        if(pessoa == null) return false;

        try {

            Pessoa pessoas[] = new Pessoa[this.getPessoa().length+1];
            for (int i = 0; i < this.getPessoa().length; i++) {
                if(!this.getPessoa()[i].equals(pessoa)){
                    pessoas[i] = this.getPessoa()[i];
                }else{ return false; }
            }

            pessoas[this.getPessoa().length] = pessoa;

            this.setPessoa(pessoas);
            this.qtdPessoa++;

            return true;


        }catch (NullPointerException ex){

            Pessoa pessoas[] = new Pessoa[1];
            pessoas[0] = pessoa;

            this.setPessoa(pessoas);
            this.qtdPessoa++;

            return true;
        }
    }

    public Pessoa buscarPessoaPorId(int id){
        for (Pessoa pessoa: this.getPessoa()) {
            if(pessoa.getId() == id) return pessoa;
        }

        return null;
    }

    public Pessoa buscarPessoaPorNome(String nome){
        for (Pessoa pessoa: this.getPessoa()) {
            if(pessoa.getNome().equals(nome)) return pessoa;
        }

        return null;
    }

    @Override
    public String toString() {
        return "CadastroDePessoa{" +
                "pessoa=" + Arrays.toString(pessoa) +
                ", qtdPessoa=" + qtdPessoa +
                '}';
    }
}
