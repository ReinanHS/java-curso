package br.concurso;

import java.util.Objects;

// Classe concreta que representa o assunto da prova a partir do id (int) e nivel (String).
public class Assunto {
    protected int id;
    protected String nivel;

    public Assunto(int id, String nivel) {
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
        else if ( o instanceof Assunto ){
            Assunto assunto = (Assunto) o;
            return this.id == assunto.id && this.nivel.equals(assunto.getNivel());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nivel);
    }

    @Override
    public String toString() {
        return "Assunto{" +
                "id=" + id +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
