package br.concurso;

// Classe concreta que representa uma questão com alternativas do tipo True ou False.
// Ela herda da classe abstrata AbsQuestao.
// Nela em que o candidato deve identificar qual alternativa está correta.
public class QuestaoMultiplaEscolha extends AbsQuestao<Character> {
    public QuestaoMultiplaEscolha(String enunciado, int totalAlternativas) {
        super(enunciado, totalAlternativas);
    }
    private char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public QuestaoMultiplaEscolha(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        super(enunciado, totalAlternativas, assunto, complexidade);
    }
    // Métodos

    // Este método deve retornar um char representando a alternativa correta em letra minúscula.
    // Por exemplo, caso a terceira alternativa esteja correta, o método deve retornar ‘c’.
    public Character getGabarito(){

        try {

            for (int i = 0; i < this.getAlternativas().length; i++) {
                if(this.getAlternativas()[i].isCorreta()){
                    return this.letras[i];
                }
            }

        }catch (NullPointerException ex){
            return 'a';
        }catch (ArrayIndexOutOfBoundsException ex){
            return this.letras[this.letras.length-1];
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o instanceof QuestaoMultiplaEscolha) {
            return super.equals(o);
        }

        return false;
    }
}
