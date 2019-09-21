package br.livraria;

import java.util.Arrays;

public class CadastroDePessoa {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private Pessoa pessoa[];
    private int qtdPessoa;
    // M�tados Especiais
    public CadastroDePessoa() { }

    public CadastroDePessoa(Pessoa[] pessoa, int qtdPessoa) {
        this.pessoa = pessoa;
        this.qtdPessoa = qtdPessoa;
    }

    // M�tados Especiais Gets e Sets

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

    // M�tados
    /**
     *
     * Essa � a fun��o respons�vel por fazer o cadastramento de um pessoa
     *
     * @return Boolean
    */
    public boolean adicionarPessoa(Pessoa pessoa){

        /*
        *     [ L�gica para o cadastramento ]
        *
        * Se o vetor n�o foi inicializado eu inicializo ele com uma posi��o com o valor que foi passado pelo par�metro.
        * Caso o contr�rio eu crio mais uma posi��o no vetor e coloco o valor que foi passado como Par�metro na ultima posi��o.
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
