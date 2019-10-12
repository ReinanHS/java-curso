package CadastroEventos;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SistemaInteracao {
    public static Scanner leia = new Scanner(System.in);
    public static Class Interface = JOptionPane.class;
    public static Random random = new Random();

    public static int TipoInterface(String msg){
        if(Interface.equals(Scanner.class)){
            System.out.print(msg);

            try {
                return leia.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Valor numérico inteiro!");
                System.out.print("O Valor foi definido como 0");
                return 0;
            }
        }else{
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(msg));
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Valor numérico inteiro!\nO Valor foi definido como 0");
                return 0;
            }
        }
    }

    public static double InterfaceDouble(String msg){
        if(Interface.equals(Scanner.class)){
            System.out.print(msg);

            try {
                return leia.nextDouble();
            }catch (InputMismatchException ex){
                System.out.println("valor numérico!");
                System.out.print("O Valor foi definido como 0");
                return 0;
            }

        }else{
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(msg));
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Valor numérico!\nO Valor foi definido como 0");
                return 0;
            }
        }
    }

    public static String pegarInterface(String msg){
        if(Interface.equals(Scanner.class)){
            System.out.print(msg);
            return leia.next();
        }else{
            return JOptionPane.showInputDialog(msg);
        }
    }

    public static void showMessage(String msg){
        if(Interface.equals(Scanner.class)){
            System.out.print(msg);
        }else{
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static Participantes criarParticipante(){

        String matricula = pegarInterface("Matricula: ");
        String nome = pegarInterface("Nome: ");

        int nivelEscolar = 0;

        do{
            nivelEscolar = TipoInterface("Digite o seu Ninel Escolar\n[1] - Fundamental\n[2] - Médio\n[3] - Superior\n\n");
        }while (nivelEscolar < 1 && nivelEscolar > 3);

        String curso = pegarInterface("Curso: ");
        String instituicao = pegarInterface("Instituição: ");

        return new Participantes(matricula, nome, nivelEscolar, curso, instituicao);
    }

    public static Professores criarProfessor(){

        String cpf = pegarInterface("CPF: ");
        int rg = TipoInterface("RG: ");

        return new Professores(criarParticipante(), cpf, rg);
    }

    public static Alunos criarAlunos(){

        String periodos = pegarInterface("Periodo: ");

        return new Alunos(criarParticipante(), periodos);
    }
   
    public static Evento criarEvento(){

        String titulo = pegarInterface("Titulo: ");
        String resumo = pegarInterface("Resumo: ");
        int qtdMaximaDeParticipnates = TipoInterface("Capacidade de participantes: ");
        String local = pegarInterface("Local: ");
        String horario = pegarInterface("Horario de inicio do Evento: ");
        double duracao = InterfaceDouble("Duração do evento (Em minutos): ");

        return new Evento(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
    }

    public static Palestra criarPalestra(){

        String publicoAlvo = pegarInterface("Publico alvo do evento: ");
        String Metodologia = pegarInterface("Metodologia: ");

        return new Palestra(criarEvento(), publicoAlvo, Metodologia);
    }

    public static Minicurso criarMinicurso(){

        String publicoAlvo = pegarInterface("Publico alvo do evento: ");
        String Metodologia = pegarInterface("Metodologia: ");

        return new Minicurso(criarEvento(), publicoAlvo, Metodologia);
    }

    public static Recurso criarRecursos(){
        int codigo = random.nextInt(200);
        String nome = pegarInterface("Nome do recurso: ");
        String descricao = pegarInterface("Descrição do recurso: ");
        int quantitativo = TipoInterface("Quantidade do recurso: ");

        return new Recurso(codigo, nome, descricao, quantitativo);
    }
}
