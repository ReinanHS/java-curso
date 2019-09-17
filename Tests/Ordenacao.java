package Tests;

import Provas.MineProva.Orcamento;

import java.util.Random;

public class Ordenacao {
    public static void main(String[] args) {
        int vetor[] = new int[10];
        Random numero = new Random();
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = numero.nextInt(20);
        }


        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("\n Ordenação \n");

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if(vetor[i] < vetor[j]){
                    int aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

    }
}
