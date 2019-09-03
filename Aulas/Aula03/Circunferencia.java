package Aulas.Aula03;

public class Circunferencia {
    // Atributos
    public Ponto centro;
    public double raio;
    public String corDaLinha;
    public String corDoPreenchimento;

    // Métados
    public void informarDados(Ponto centro, double raio, String corDaLinha, String corDoPreenchimento) {
        this.centro = centro;
        this.raio = raio;
        this.corDaLinha = corDaLinha;
        this.corDoPreenchimento = corDoPreenchimento;
    }

    public double area(){ return (3.14*(this.raio*this.raio)); }

    public double perimetro(){ return (2*3.14*this.raio); }

    public void imprimirDados(){
        this.centro.imprimirDados();
        System.out.println("Raio: "+this.raio+"\nCor Da Linha: "+this.corDaLinha+"\nCor Do Preenchimento: "+this.corDoPreenchimento);
    }
}
