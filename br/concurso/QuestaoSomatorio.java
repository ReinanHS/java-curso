package br.concurso;
// Classe concreta que representa uma questão de somatório, em que cada alternativa está associado a um valor do tipo inteiro.
// Ela herda da classe abstrata AbsQuestao.
// Nela em que o candidato deve julgar as alternativas com Verdadeiro ou Falso
// para cada alternativa e o resultado da questão, ou seja, o gabarito é o valor inteiro correspondente.
public class QuestaoSomatorio extends AbsQuestao<Integer>{
    public QuestaoSomatorio(String enunciado, int totalAlternativas) {
        super(enunciado, totalAlternativas);
    }

    public QuestaoSomatorio(String enunciado, int totalAlternativas, Assunto assunto, Complexidade complexidade) {
        super(enunciado, totalAlternativas, assunto, complexidade);
    }

    // Métodos

    // Este método deve retornar um valor inteiro referente a soma das alternativas verdadeiras.
    // O cálculo é dado pelo somatório dos índices da alternativas elevado ao quadrado das alternativas corretas.
    // Por exemplo, considerando uma questão com 5 alternativas, sendo que apenas a terceira e a última estão corretas, o
    // cálculo seria:
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
