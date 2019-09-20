package Tests.ProvaPrimeiroBimestre;

public class Consulta {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private int codConsulta;
    private Medico medicoResponsavel;
    private int Tempo;
    // M�tados Especiais

    public Consulta(int codConsulta, Medico medicoResponsavel) {
        this.codConsulta = codConsulta;
        this.medicoResponsavel = medicoResponsavel;
    }


    // M�tados Especiais Gets e Sets

    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public int getTempo() {
        return Tempo;
    }

    public void setTempo(int tempo) {
        Tempo = tempo;
    }

    // M�tados

    @Override
    public String toString() {
        return "Consulta{" +
                "codConsulta='" + codConsulta + '\'' +
                ", medicoResponsavel=" + medicoResponsavel +
                '}';
    }
}
