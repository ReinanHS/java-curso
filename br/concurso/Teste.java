package br.concurso;

import java.util.Arrays;

public class Teste {

    static int MAX_QUESTOES = 3;
    static int MAX_ALTERNATIVAS = 5;

    static Prova prova;
    static IQuestao questao;

    public static IQuestao criarQuestao(int id, int totalAlternativas, String tipo) {
        String enunciado = "Q. "+id;

        Alternativa[] alternativas = new Alternativa[MAX_ALTERNATIVAS];

        //System.out.println(alternativas);

        for (int i = 0; i < MAX_ALTERNATIVAS; i++)
            alternativas[i] = new Alternativa("alternativa " +(i+1), false);

        //System.out.println(alternativas);

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
        //System.out.println(questao);
        return questao;
    }

    public static boolean criarQuestaoVF(int id) throws LimiteExcedidoException {
        prova.addQuestao(criarQuestao(id, MAX_ALTERNATIVAS, "VF"));

        //System.out.println(prova);
        String enunciadoEsperado = "Q. " +id;
        String enunciadoObtido = prova.getQuestoes()[id-1].getEnunciado();

        boolean[] gabaritoEsperado = {false, false, true, false, true};
        boolean[] gabaritoObtido = (boolean[]) prova.getQuestoes()[id-1].getGabarito();

        System.out.println(Arrays.toString((boolean[]) prova.getQuestoes()[id-1].getGabarito()));
        System.out.println(Arrays.toString((boolean[])questao.getGabarito()));

        return enunciadoEsperado.equals(enunciadoObtido) && Arrays.equals(gabaritoObtido, gabaritoEsperado);
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

        //System.out.println(prova.getQuestoes()[2].getGabarito());

        char gabaritoEsperado = 'c';
        char gabaritoObtido = (char) prova.getQuestoes()[id-1].getGabarito();

        return enunciadoEsperado.equals(enunciadoObtido) && (gabaritoEsperado == gabaritoObtido);
    }

    public static void main(String[] args) {
        prova = new Prova(MAX_QUESTOES);

        //System.out.println(criarQuestao(1, MAX_ALTERNATIVAS, "VF"));

        try {
            criarQuestaoVF(1);
        } catch (LimiteExcedidoException e) {
            e.printStackTrace();
        }

//        try {
//            criarQuestaoS(2);
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//        }

//        try {
//            criarQuestaoME(3);
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//        }

        //System.out.println(prova);
//        try {
//            prova.getQuestoes()[0].addAlternativa(new Alternativa("alternativa acima", false));
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//            //e.getMessage();
//        }


//        try {
//            prova.getQuestoes()[0].addAlternativa(new Alternativa("alternativa acima", false));
//        } catch (LimiteExcedidoException e) {
//            System.out.println("(2,0 pontos) Adicionar alternativa acima do limite da questão = " + (e.getMessage().equals("Limite do repositório foi excedido.")?"acertou":"errou"));
//        }

    }
}
