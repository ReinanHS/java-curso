package br.concurso;
// Classe concreta que representa uma quest�o de somat�rio, em que cada alternativa est� associado a um valor do tipo inteiro.
// Ela herda da classe abstrata AbsQuestao.
// Nela em que o candidato deve julgar as alternativas com Verdadeiro ou Falso
// para cada alternativa e o resultado da quest�o, ou seja, o gabarito � o valor inteiro correspondente.
public class QuestaoSomatorio extends AbsQuestao<Integer>{
    public QuestaoSomatorio(String enunciado, int totalAlternativas) {
        super(enunciado, totalAlternativas);
    }

    public QuestaoSomatorio(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        super(enunciado, totalAlternativas, assunto, complexidade);
    }

    // M�todos

    // Este m�todo deve retornar um valor inteiro referente a soma das alternativas verdadeiras.
    // O c�lculo � dado pelo somat�rio dos �ndices da alternativas elevado ao quadrado das alternativas corretas.
    // Por exemplo, considerando uma quest�o com 5 alternativas, sendo que apenas a terceira e a �ltima est�o corretas, o
    // c�lculo seria:
    /*
        x = 0*2^0
        0 + 0*2^1
        1 + 1*2^2
        2 + 0*2^3
        3 + 1*2^4
        4 = 20
    * */

    public Integer getGabarito(){
        try {

            int soma = 0;

            for (int i = 0; i < this.getAlternativas().length; i++) {
                if(this.getAlternativas()[i].isCorreta()){
                    soma += 1* Math.pow(2,i);
                }else{
                    soma += 0* Math.pow(2,i);
                }
            }

            return soma;

        }catch (NullPointerException ex){
            return 0;
        }
    }
}
