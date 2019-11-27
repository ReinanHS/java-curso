package br.concurso;

import java.util.Objects;

// Classe concreta que representa a complexidade da prova a partir do id (int) e nivel (String).
public class Complexidade {
    protected int id;
    protected String nivel;

    public Complexidade(int id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if ( o instanceof Complexidade ){
            Complexidade complexidade = (Complexidade) o;
            return this.id == complexidade.id && this.nivel.equals(complexidade.getNivel());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nivel);
    }

    @Override
    public String toString() {
        return "Complexidade{" +
                "id=" + id +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
