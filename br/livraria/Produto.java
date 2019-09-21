package br.livraria;

public class Produto {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    protected int id;
    protected String titulo;
    // M�tados Especiais

    public Produto(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // M�tados Especiais Gets e Sets

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

    // M�tados

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
