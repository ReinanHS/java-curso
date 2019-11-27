package br.concurso;
// Classe concreta que representa uma quest�o com alternativas do tipo True ou False.
// Ela herda da classe abstrata AbsQuestao. Nela em que o candidato deve julgar as alternativas com True ou False.
public class QuestaoVF extends AbsQuestao<boolean[]> {
    public QuestaoVF(String enunciado, int totalAlternativas) {
        super(enunciado, totalAlternativas);
    }

    public QuestaoVF(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        super(enunciado, totalAlternativas, assunto, complexidade);
    }

    // M�todos
    // Este m�todo deve retornar o vetor contendo para cada item se ele � True ou False.
    // Por exemplo, considerando uma quest�o com 5 alternativas, sendo que apenas a terceira e a �ltima est�o corretas,
    // o retorno seria: [false, false, true, false, true]
    public boolean[] getGabarito(){

        try{
            boolean[] valores = new boolean[this.getAlternativas().length];

            for (int i = 0; i < this.getAlternativas().length; i++) {
                valores[i] = this.getAlternativas()[i].isCorreta();
            }

            return valores;
        }catch (NullPointerException ex){
            return new boolean[0];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o instanceof QuestaoVF) {
            return super.equals(o);
        }

        return false;
    }
}
