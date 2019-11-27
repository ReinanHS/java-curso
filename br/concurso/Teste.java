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

        Assunto matematica = new Assunto(id,"Matematica");
        Complexidade facil = new Complexidade(id, "Facil");
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

        Alternativa[] alternativas = new Alternativa[MAX_ALTERNATIVAS];
        for (int i = 0; i < MAX_ALTERNATIVAS; i++)
            alternativas[i] = new Alternativa("alternativa " +(i+1), false);
        questao = new QuestaoVF("Enunciado", 4);
        questao.setEnunciado("Enunciado 1");
        alternativas[2].setCorreta(true);
        alternativas[4].setCorreta(true);

        Assunto matematica = new Assunto(1,"Matematica");
        Complexidade facil = new Complexidade(1, "Facil");
        questao.setAlternativas(alternativas);
        questao.setAssunto(matematica);
        questao.setComplexidade(facil);

        Prova novaProva = new Prova(3);

        try {
            prova.addQuestao(questao);
            novaProva.addQuestao(questao);
        } catch (LimiteExcedidoException e) {
            e.printStackTrace();
        }

        System.out.println(prova.equals(questao));

//        try {
//            criarQuestaoVF(1);
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            criarQuestaoS(2);
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            criarQuestaoME(3);
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(prova);
//        try {
//            prova.getQuestoes()[0].addAlternativa(new Alternativa("alternativa acima", false));
//        } catch (LimiteExcedidoException e) {
//            e.printStackTrace();
//            //e.getMessage();
//        }
//
//
//        try {
//            prova.getQuestoes()[0].addAlternativa(new Alternativa("alternativa acima", false));
//        } catch (LimiteExcedidoException e) {
//            System.out.println("(2,0 pontos) Adicionar alternativa acima do limite da questão = " + (e.getMessage().equals("Limite do repositório foi excedido.")?"acertou":"errou"));
//        }

        //imprimirProva();

    }
}
