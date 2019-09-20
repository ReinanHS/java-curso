package Tests.ProvaPrimeiroBimestre;

public class Pediatria extends Medico{
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private byte anosExperiencia;
    // Métados Especiais

    public Pediatria(int CRM, String nome, Double vlrConsulta, byte anosExperiencia) {
        super(CRM, nome, vlrConsulta);
        this.anosExperiencia = anosExperiencia;
    }

    // Métados Especiais Gets e Sets

    public byte getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(byte anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    // Métados

    public double totalConsulta(int pTempoTotal){
        double valor = this.vlrConsulta * pTempoTotal;
        return (this.getAnosExperiencia() >= 10) ? valor*2 : valor;
    }

    @Override
    public String toString() {
        return "Medico{ { "+super.toString()+" }, AnosEsoeciencia: "+this.getAnosExperiencia()+" }";
    }
}
