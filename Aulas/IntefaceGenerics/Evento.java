package Aulas.IntefaceGenerics;

import java.util.Objects;

public class Evento {

    private int id;
    private String titulo;
    private String responsavel;

    public Evento(int id, String titulo, String responsavel) {
        this.id = id;
        this.titulo = titulo;
        this.responsavel = responsavel;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Evento)) return false;
//        Evento evento = (Evento) o;
//        return id == evento.id;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Evento){
            return this.id == ((Evento)obj).id;
        }else if(obj instanceof Integer) {
            return this.id == ((Integer)obj);
        }

        return false;
    }
}
