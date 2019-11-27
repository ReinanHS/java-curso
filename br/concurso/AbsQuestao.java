package br.concurso;

import java.util.Arrays;

// Classe abstrata que representa uma quest�o e implementa a interface IQuestao.
public abstract class AbsQuestao<G> implements IQuestao<G> {
    // Atributos
    private String enunciado;
    private int totalAlternativas;
    private Assunto assunto;
    private Complexidade complexidade;
    private Alternativa[] alternativas;

    // Construtor de uma quest�o.
    // Para instanciar uma quest�o � necess�rio informar o enunciado e o total m�ximo de alternativas.
    public AbsQuestao(String enunciado, int totalAlternativas) {
        this.enunciado = enunciado;
        this.totalAlternativas = totalAlternativas;
    }
    // Para instanciar uma quest�o � necess�rio informar o enunciado, o total m�ximo de alternativas, assunto e complexidade.
    public AbsQuestao(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        this.enunciado = enunciado;
        this.totalAlternativas = totalAlternativas;
        this.assunto = assunto;
        this.complexidade = complexidade;
    }

    // M�tados

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

                if (!achou) throw new LimiteExcedidoException("Limite do reposit�rio foi excedido.");

            }else throw new LimiteExcedidoException("Limite do reposit�rio foi excedido.");
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
}
