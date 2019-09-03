package Aulas.Aula03;

public class Main {
    public static void main(String[] args) {
        Ponto p = new Ponto();
        Circunferencia c = new Circunferencia();

        // Imprimir os dados
        //p.imprimirDados();
        // Set dados
        p.informarDados(6.0, 3.5, 1.0, "rgb(255,255,255)");
        // Imprimir os dados atualizados
        //p.imprimirDados();

        // Atualizar os dadis da Circunferencia
        c.informarDados(p,8.0,"rbg(150,150,150)", "rbg(150,0,0)");
        c.imprimirDados();

        // Imprimir o área da circunferência
        System.out.println("Área da circunferência: "+c.area());
        // Imprimir o Perímetro da circunferência
        System.out.println("Perímetro da circunferência: "+c.perimetro());
    }
}
