package Tests.Atividades;

import Tests.Atividades.Herenca.Empregado;
import Tests.Atividades.Herenca.Programador;

public class Main {
    public static void main(String[] args) {
        Empregado lista[] = new Empregado[5];

        lista[0] = new Empregado(1, "João", 1800);
        lista[1] = new Programador(2, "Reinan", 4900, "Java");
        lista[2] = new Empregado(3, "Lucas", 1900);
        lista[3] = new Programador(4, "Gabriel", 4800, "Java");
        lista[4] = new Programador(5, "Davi", 5000, "Python");

        double maiorSalario = 0;

        for (Empregado funcionario: lista) {
            if(funcionario instanceof Programador){
                if(funcionario.getSalario() > maiorSalario && ((Programador) funcionario).getLinguagem().equals("Python") ){
                    maiorSalario = funcionario.getSalario();
                }
            }
        }

        System.out.println(maiorSalario);
    }
}

