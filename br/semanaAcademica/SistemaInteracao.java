package br.semanaAcademica;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SistemaInteracao {
    public static Scanner input = new Scanner(System.in);
    public static Class UI_TIPO = JOptionPane.class;
    public static Random random = new Random();

    public static int getIntUI(String mgs){
        if(UI_TIPO.equals(Scanner.class)){
            System.out.print(mgs);

            try {
                return input.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Atenção você digitou uma String e o valor aceito é Inteiro!");
                System.out.print("O Valor foi definido como 0");
                return 0;
            }

        }else{

            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mgs));
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Atenção você digitou uma String e o valor aceito é Inteiro!\nO Valor foi definido como 0");
                return 0;
            }

        }
    }

    public static int getMenuOpicao(String mgs){

        String valor = "";

        if(UI_TIPO.equals(Scanner.class)){
            System.out.print(mgs);

            valor = input.next();

        }else{
            valor = JOptionPane.showInputDialog(mgs);
        }

        if(valor.equals("1")){
            return 1;
        }else if(valor.equals("2")){
            return 2;
        }else if(valor.equals("3")){
            return 3;
        }else if(valor.equals("4")){
            return 4;
        }else if(valor.equals("5")){
            return 5;
        }else if(valor.equals("6")){
            return 6;
        }else if(valor.equals("7")){
            return 7;
        }else if(valor.equals("8")){
            return 8;
        }else if(valor.equals("9")){
            return 9;
        }else if(valor.equals("10")){
            return 10;
        }else {
            return -1;
        }
    }

    public static double getDoubleUI(String mgs){
        if(UI_TIPO.equals(Scanner.class)){
            System.out.print(mgs);

            try {
                return input.nextDouble();
            }catch (InputMismatchException ex){
                System.out.println("Atenção você digitou uma String e o valor aceito é Double!");
                System.out.print("O Valor foi definido como 0");
                return 0;
            }

        }else{

            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mgs));
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Atenção você digitou uma String e o valor aceito é Double!\nO Valor foi definido como 0");
                return 0;
            }

        }
    }

    public static String getUI(String mgs){
        if(UI_TIPO.equals(Scanner.class)){
            System.out.print(mgs);
            return input.next();
        }else{
            return JOptionPane.showInputDialog(mgs);
        }
    }

    public static void showMessage(String mgs){
        if(UI_TIPO.equals(Scanner.class)){
            System.out.print(mgs);
        }else{
            JOptionPane.showMessageDialog(null, mgs);
        }
    }

    public static Participante criarParticipante(){

        //String matricula = getUI("Digite o sua matricula aqui: ");
        String matricula = "2019"+random.nextInt(100)+""+random.nextInt(100);
        String nome = getUI("Digite o seu nome aqui: ");

        int nivelEscolar = 0;

        do{
            nivelEscolar = getIntUI("Digite aqui o seu Ninel Escolar\n[01] - Fundamental\n[02] - Médio\n[03] - Superior\n\n");
        }while (nivelEscolar < 1 || nivelEscolar > 3);

        String curso = getUI("Digite o seu curso aqui: ");
        String instituicao = getUI("Digite o sua instituição aqui: ");

        return new Participante(matricula, nome, nivelEscolar, curso, instituicao);
    }

    public static Professor criarProfessor(){

        String cpf = getUI("Digite o seu CPF aqui: ");
        int rg = getIntUI("Digite o sua RG aqui: ");

        return new Professor(criarParticipante(), cpf, rg);
    }

    public static Alunos criarAlunos(){

        String periodos = getUI("Digite o seu periodo aqui: ");
        int TotalMaterias = getIntUI("Digite o total de materias aqui: ");
        Materia materias[] = new Materia[TotalMaterias];

        for (int i = 0; i < TotalMaterias; i++) {
            materias[i] = criarMateria();
        }

        return new Alunos(criarParticipante(), periodos, materias);
    }

    public static Materia criarMateria(){

        int codigo = random.nextInt(100);
        String nome = getUI("Digite o nome da matéria aqui: ");
        int quantitativo = 0;

        return new Materia(codigo, nome, quantitativo);
    }

    public static Evento criarEvento(){

        String titulo = getUI("Digite aqui o titulo: ");
        String resumo = getUI("Digite aqui o resumo: ");
        int qtdMaximaDeParticipnates = getIntUI("Digite o totsl maximo de participantes: ");
        String local = getUI("Digite aqui o local: ");
        String horario = getUI("Digite aqui o horario de inicio do Evento: ");
        double duracao = getDoubleUI("Digite aqui em minutos a duração do evento: ");

        return new Evento(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
    }

    public static Palestra criarPalestra(){

        String publicoAlvo = getUI("Digite o publico alvo do evento: ");
        String Metodologia = getUI("Digite aqui a metodologia: ");

        return new Palestra(criarEvento(), publicoAlvo, Metodologia);
    }

    public static Minicurso criarMinicurso(){

        String publicoAlvo = getUI("Digite o publico alvo do evento: ");
        String Metodologia = getUI("Digite aqui a metodologia: ");

        return new Minicurso(criarEvento(), publicoAlvo, Metodologia);
    }

    public static Recursos criarRecursos(){
        int codigo = random.nextInt(200);
        String nome = getUI("Digite aqui o nome do recurso: ");
        String descricao = getUI("Digite aqui a descrição do recurso: ");
        int quantitativo = getIntUI("Digite aqui a quantidade do recurso: ");

        return new Recursos(codigo, nome, descricao, quantitativo);
    }
}
