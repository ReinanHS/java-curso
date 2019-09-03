package Aulas.Aula02.Lampadas;

public class Lampada {
    public String Cor;
    public String Modelo;
    public int ValorDeCompra;
    public Boolean Status = false;

    public Lampada(String cor, String modelo, int valorDeCompra) {
        this.Cor = cor;
        this.Modelo = modelo;
        this.ValorDeCompra = valorDeCompra;
        //this.Status = status;
    }

    public void Ligar(){
        this.Status = true;
        System.out.println("A lampada está ligada!");
    }

    public void Desligar(){
        this.Status = false;
        System.out.println("A lampada está desligada!");
    }

    public void TrocarPorOutra(Lampada lampada){

        this.Cor = lampada.Cor;
        this.Modelo = lampada.Modelo;
        this.ValorDeCompra = lampada.ValorDeCompra;
        this.Status = lampada.Status;

        System.out.println("A lampada foi trocada pro outra!");
    }

    public void DadosDoProduto(){
        System.out.println("Cor: "+this.Cor);
        System.out.println("Modelo: "+this.Modelo);
        System.out.println("Valor: "+this.ValorDeCompra);
        System.out.println("Status: "+this.Status);
    }
}
