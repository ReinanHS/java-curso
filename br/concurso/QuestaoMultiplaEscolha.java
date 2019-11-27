package br.concurso;
// Classe concreta que representa uma quest�o com alternativas do tipo True ou False.
// Ela herda da classe abstrata AbsQuestao.
// Nela em que o candidato deve identificar qual alternativa est� correta.
public class QuestaoMultiplaEscolha extends AbsQuestao<Character> {
    public QuestaoMultiplaEscolha(String enunciado, int totalAlternativas) {
        super(enunciado, totalAlternativas);
    }
    private char[] letras = {'a', 'b', 'c', 'd', 'e'};

    public QuestaoMultiplaEscolha(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        super(enunciado, totalAlternativas, assunto, complexidade);
    }
    // M�todos

    // Este m�todo deve retornar um char representando a alternativa correta em letra min�scula.
    // Por exemplo, caso a terceira alternativa esteja correta, o m�todo deve retornar �c�.
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


}
