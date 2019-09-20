package Tests.ProvaPrimeiroBimestre;

public class Medico {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    public int CRM;
    public String Nome;
    public Double vlrConsulta;
    // Métados Especiais

    public Medico(int CRM, String nome, Double vlrConsulta) {
        this.CRM = CRM;
        this.Nome = nome;
        this.vlrConsulta = vlrConsulta;
    }

    // Métados Especiais Gets e Sets

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getVlrConsulta() {
        return vlrConsulta;
    }

    public void setVlrConsulta(Double vlrConsulta) {
        this.vlrConsulta = vlrConsulta;
    }

    // Métados
    public double totalConsulta(int pTempoTotal){
        return this.vlrConsulta * pTempoTotal;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "CRM=" + CRM +
                ", Nome='" + Nome + '\'' +
                ", vlrConsulta=" + vlrConsulta +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Medico){
            return (( (Medico) obj).CRM == this.CRM) ? true : false;
        }

        return false;
    }
}
