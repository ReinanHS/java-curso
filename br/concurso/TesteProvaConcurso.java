package br.concurso;

import br.concurso.*;

import java.util.Arrays;

public class TesteProvaConcurso {

    static int MAX_QUESTOES = 3;
    static int MAX_ALTERNATIVAS = 5;

    static Prova prova;
    static IQuestao questao;

    public static IQuestao criarQuestao(int id, int totalAlternativas, String tipo) {
        String enunciado = "Q. "+id;

        Alternativa[] alternativas = new Alternativa[MAX_ALTERNATIVAS];
        for (int i = 0; i < MAX_ALTERNATIVAS; i++)
            alternativas[i] = new Alternativa("alternativa " +(i+1), false);

        if (tipo.equals("VF")) {
            questao = new QuestaoVF(enunciado, totalAlternativas);
            alternativas[2].setCorreta(true);
            alternativas[4].setCorreta(true);
        } else if (tipo.equals("S")) {
            questao = new QuestaoSomatorio(enunciado, totalAlternativas);
            alternativas[2].setCorreta(true);
            alternativas[4].setCorreta(true);
        } else if (tipo.equals("ME")) {
            questao = new QuestaoMultiplaEscolha(enunciado, totalAlternativas);
            alternativas[2].setCorreta(true);
        }

        questao.setAlternativas(alternativas);
        return questao;
    }

    public static boolean criarQuestaoS(int id) throws LimiteExcedidoException {
        prova.addQuestao(criarQuestao(id, MAX_ALTERNATIVAS, "S"));

        String enunciadoEsperado = "Q. " +id;
        String enunciadoObtido = prova.getQuestoes()[id-1].getEnunciado();

        int gabaritoEsperado = 20;
        int gabaritoObtido = (int) prova.getQuestoes()[id-1].getGabarito();

        return enunciadoEsperado.equals(enunciadoObtido)
                && (gabaritoEsperado == gabaritoObtido);
    }

    public static boolean criarQuestaoME(int id) throws LimiteExcedidoException {
        prova.addQuestao(criarQuestao(id, MAX_ALTERNATIVAS, "ME"));

        String enunciadoEsperado = "Q. " +id;
        String enunciadoObtido = prova.getQuestoes()[id-1].getEnunciado();

        char gabaritoEsperado = 'c';
        char gabaritoObtido = (char) prova.getQuestoes()[id-1].getGabarito();

        return enunciadoEsperado.equals(enunciadoObtido)
                && (gabaritoEsperado == gabaritoObtido);
    }

    public static boolean criarQuestaoVF(int id) throws LimiteExcedidoException {
        prova.addQuestao(criarQuestao(id, MAX_ALTERNATIVAS, "VF"));

        String enunciadoEsperado = "Q. " +id;
        String enunciadoObtido = prova.getQuestoes()[id-1].getEnunciado();

        boolean[] gabaritoEsperado = {false, false, true, false, true};
        boolean[] gabaritoObtido = (boolean[]) prova.getQuestoes()[id-1].getGabarito();

        return enunciadoEsperado.equals(enunciadoObtido)
                && Arrays.equals(gabaritoObtido, gabaritoEsperado);
    }

    public static void imprimirProva() {
        System.out.println("\n\n:::::: Prova ::::::");
        IQuestao[] questoes = prova.getQuestoes();
        for (int i = 0; i < questoes.length; i++) {
            System.out.println("\n:: Questão: " + questoes[i].getEnunciado()+" ::");
            System.out.println("Assunto: " + questoes[i].getAssunto());
            System.out.println("Complexidade: " + questoes[i].getAssunto());
            System.out.println("Alternativas: ");
            Alternativa[] alternativas = questoes[i].getAlternativas();
            for (int j = 0; j < alternativas.length; j++)
                System.out.println(alternativas[j].getDescricao());
            Object gabarito = questoes[i].getGabarito();
            if (i == 0)
                System.out.println("Gabarito: " + Arrays.toString((boolean[]) gabarito));
            else
                System.out.println("Gabarito: " + gabarito);
        }
    }

    public static void main(String[] args) {
        prova = new Prova(MAX_QUESTOES);
        try {
            System.out.println("(2,0 pontos) Criar questao do tipo V ou F = " + ((criarQuestaoVF(1))?"acertou":"errou"));
        } catch (LimiteExcedidoException e) {
            System.out.println("(2,0 pontos) Criar questao do tipo V ou F = errou");
        }

        try {
            System.out.println("(2,0 pontos) Criar questao do tipo somatorio = " + ((criarQuestaoS(2))?"acertou":"errou"));
        } catch (LimiteExcedidoException e) {
            System.out.println("(2,0 pontos) Criar questao do tipo somatorio = errou");
        }

        try {
            System.out.println("(2,0 pontos) Criar questao do tipo multipla escolha = " + ((criarQuestaoME(3))?"acertou":"errou"));
        } catch (LimiteExcedidoException e) {
            System.out.println("(2,0 pontos) Criar questao do tipo multipla escolha = errou");
        }
        try {
            prova.getQuestoes()[0].addAlternativa(new Alternativa("alternativa acima", false));
        } catch (LimiteExcedidoException e) {
            System.out.println("(2,0 pontos) Adicionar alternativa acima do limite da questão = " + (e.getMessage().equals("Limite do repositório foi excedido.")?"acertou":"errou"));
        }

        //System.out.println(prova);
        imprimirProva();
    }
}