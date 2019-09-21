package br.livraria;

public class Pessoa{
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private int id;
    private String nome;
    // M�tados Especiais

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // M�tados Especiais Gets e Sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // M�tados

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pessoa){
            return ( ((Pessoa)obj).id == this.id);
        }

        return false;
    }
}
