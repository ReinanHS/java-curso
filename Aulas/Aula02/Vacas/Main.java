package Aulas.Aula02.Vacas;

public class Main {
    public static void main(String[] args) {
        Vaca vacaDell = new Vaca();

        vacaDell.peso = 250.00;
        vacaDell.tamanho = 2.6;
        vacaDell.raca = "Canal Do Boi";
        vacaDell.registro = "CanalDoBoi@gmail.com";

        vacaDell.caminhar(15.0);
        vacaDell.comer("Sei la", 15.0);

        System.out.println(vacaDell.produzirLeite());

        vacaDell.ruminar();
    }
}
