package Aulas.Aula03;

public class Ponto {
    // Atributos
    public double X, Y, Z;
    public String cor;
    // Metados
    public void informarDados(double pX, double pY, double pZ, String pCor){
        this.X = pX;
        this.Y = pY;
        this.Z = pZ;
        this.cor = pCor;
    }
    public void alterarCor(String pCor){
        this.cor = pCor;
    }
    public void imprimirDados(){
        System.out.println("X: "+this.X+"\nY: "+this.Y+"\nZ: "+this.Z+"\nCor: "+this.cor);
    }

}
