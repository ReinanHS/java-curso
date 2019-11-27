package br.concurso;

import java.util.Objects;

// Classe concreta que representa a alternativa da questão representada pela descricao (String) e pelo nivel (boolean)
public class Alternativa {
    private String descricao;
    private boolean correta;

    public Alternativa(String descricao, boolean correta) {
        this.descricao = descricao;
        this.correta = correta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if ( o instanceof Alternativa){
            Alternativa alternativa = (Alternativa) o;
            return this.descricao.equals(alternativa.getDescricao()) && this.isCorreta() == alternativa.isCorreta();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, correta);
    }

    @Override
    public String toString() {
        return "Alternativa{" +
                "descricao='" + descricao + '\'' +
                ", correta=" + correta +
                '}';
    }
}
