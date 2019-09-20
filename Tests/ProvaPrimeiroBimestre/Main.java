package Tests.ProvaPrimeiroBimestre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clinica boaClimica = new Clinica("Boa Climica", "Simão Dias");


        Scanner input = new Scanner(System.in);

        int valor = input.nextInt();

        switch (valor){
            case 1: {

                Medico medico = new Medico();

                break;
            }
        }
    }
}
