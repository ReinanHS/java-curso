package br.livraria;

public class Produto {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    protected int id;
    protected String titulo;
    // Métados Especiais

    public Produto(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // Métados Especiais Gets e Sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Métados

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Produto){
            return ( ((Produto)obj).id == this.id);
        }

        return false;
    }
}
