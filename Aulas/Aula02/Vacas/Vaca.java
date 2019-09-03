package Aulas.Aula02.Vacas;

public class Vaca {
    public String registro;
    public String raca;
    public Double tamanho;
    public Double peso;

    public void comer(String alimento, Double quantidade){
        System.out.println("A vaca está comendo "+quantidade+"g de "+alimento+"...");
        this.peso = this.peso + ( (this.peso*2) / 100 );
    }

    public void ruminar(){
        System.out.println("Aaaaaaaa sei la o que....");
    }

    public double produzirLeite(){
        return ( (this.peso*2) / 100 );
    }

    public void caminhar(Double distancia){
        System.out.println("A Vaca caminhar....");
        System.out.println("Distancia: "+distancia);
    }

    public void ImprimirDados(){
        
    }
}