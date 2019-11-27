package br.concurso;

import java.util.Arrays;

// Classe concreta que representa uma prova de concurso. As provas s�o formadas por um conjunto de quest�es do tipo IQuest�o.
public class Prova {

    private int capacidade;
    private IQuestao[] iQuestaos;
    private int cont = 0;

    public Prova(int capacidade) {
        this.capacidade = capacidade;
        this.iQuestaos = new IQuestao[capacidade];

    }

    // M�todos

    // Adiciona uma quest�o a prova. O m�todo lan�a uma exce��o do tipo LimiteExcedidoException
    public boolean addQuestao(IQuestao questao) throws LimiteExcedidoException {

        try{

            for (int i = 0; i < this.iQuestaos.length; i++) {
                if(this.iQuestaos[i] == null){
                    this.iQuestaos[i] = questao;
                    return true;
                }
            }

            throw new LimiteExcedidoException();

        }catch (NullPointerException ex){
            if(this.capacidade > 0){
                this.iQuestaos = new IQuestao[this.capacidade];
                this.iQuestaos[0] = questao;

                return true;
            }

            this.iQuestaos = new IQuestao[1];
            this.iQuestaos[0] = questao;

            return true;

        }
    }

    // Retorna as quest�es cadastradas.
    public IQuestao[] getQuestoes(){
        return this.iQuestaos;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if ( o instanceof Prova ){
            Prova prova = (Prova) o;
            return this.capacidade == prova.capacidade && Arrays.deepEquals(this.iQuestaos, prova.iQuestaos);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Prova{" +
                "capacidade=" + capacidade +
                ", iQuestaos=" + Arrays.toString(iQuestaos) +
                ", cont=" + cont +
                '}';
    }
}
