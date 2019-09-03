package Aulas.Aula02.Lampadas;

public class Main {
    public static void main(String[] args){
        Lampada lampada1 = new Lampada("branco", "LED", 220);
        Lampada lampada2 = new Lampada("branco", "LED", 120);

        lampada1.Ligar();
    }
}
