package Tests.ProvaPrimeiroBimestre;

public class ClinicoGeral extends Medico {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private boolean realizaCirugia;
    // M�tados Especiais

    public ClinicoGeral(int CRM, String nome, Double vlrConsulta, boolean realizaCirugia) {
        super(CRM, nome, vlrConsulta);
        this.realizaCirugia = realizaCirugia;
    }

    // M�tados Especiais Gets e Sets

    public boolean isRealizaCirugia() {
        return realizaCirugia;
    }

    public void setRealizaCirugia(boolean realizaCirugia) {
        this.realizaCirugia = realizaCirugia;
    }

    // M�tados

    public double totalConsulta(int pTempoTotal){

        double valor = this.vlrConsulta * pTempoTotal;

        return (this.isRealizaCirugia()) ? valor * 10000 : valor;
    }

    @Override
    public String toString() {
        return "ClinicoGeral{ { "+super.toString()+" }, RealizaCirugia: "+this.isRealizaCirugia()+" }";
    }
}
