package br.concurso;

import java.util.Arrays;
import java.util.Objects;

// Classe abstrata que representa uma questão e implementa a interface IQuestao.
public abstract class AbsQuestao<G> implements IQuestao<G> {
    // Atributos
    private String enunciado;
    private int totalAlternativas;
    private Assunto assunto;
    private Complexidade complexidade;
    private Alternativa[] alternativas;

    // Construtor de uma questão.
    // Para instanciar uma questão é necessário informar o enunciado e o total máximo de alternativas.
    public AbsQuestao(String enunciado, int totalAlternativas) {
        this.enunciado = enunciado;
        this.totalAlternativas = totalAlternativas;
    }
    // Para instanciar uma questão é necessário informar o enunciado, o total máximo de alternativas, assunto e complexidade.
    public AbsQuestao(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        this.enunciado = enunciado;
        this.totalAlternativas = totalAlternativas;
        this.assunto = assunto;
        this.complexidade = complexidade;
    }

    // Métados

    @Override
    public String getEnunciado() {
        return this.enunciado;
    }

    @Override
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public Alternativa[] getAlternativas() {
        return this.alternativas;
    }

    @Override
    public void setAlternativas(Alternativa[] alternativas) {
        this.alternativas = alternativas;
        this.totalAlternativas = alternativas.length;
    }

    @Override
    public void addAlternativa(Alternativa alternativa) throws LimiteExcedidoException {
        try{
            if(this.getAlternativas().length <= this.totalAlternativas){

                boolean achou = false;

                for (int i = 0; i < this.getAlternativas().length; i++) {
                    if(this.getAlternativas()[i] == null && !achou){
                        this.alternativas[i] = alternativa;
                        achou = true;
                    }
                }

                if (!achou) throw new LimiteExcedidoException("Limite do repositório foi excedido.");

            }else throw new LimiteExcedidoException("Limite do repositório foi excedido.");
        }catch (NullPointerException ex){
            Alternativa[] alternativas = new Alternativa[1];
            alternativas[0] = alternativa;
            this.setAlternativas(alternativas);
        }
    }

    @Override
    public Assunto getAssunto() {
        return this.assunto;
    }

    @Override
    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    @Override
    public Complexidade getComplexidade() {
        return this.complexidade;
    }

    @Override
    public void setComplexidade(Complexidade complexidade) {
        this.complexidade = complexidade;
    }

    @Override
    public String toString() {
        return "AbsQuestao{" +
                "enunciado='" + enunciado + '\'' +
                ", totalAlternativas=" + totalAlternativas +
                ", assunto=" + assunto +
                ", complexidade=" + complexidade +
                ", alternativas=" + Arrays.toString(alternativas) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o instanceof AbsQuestao) {
            AbsQuestao<G> that = (AbsQuestao<G>) o;
            return this.totalAlternativas == that.totalAlternativas &&
                    this.enunciado.equals(that.enunciado) &&
                    this.assunto.equals(that.assunto) &&
                    this.complexidade.equals(that.complexidade) &&
                    Arrays.equals(alternativas, that.alternativas);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(enunciado, totalAlternativas, assunto, complexidade);
        result = 31 * result + Arrays.hashCode(alternativas);
        return result;
    }
}
