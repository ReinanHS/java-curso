package Tests.ProvaPrimeiroBimestre;

import java.util.Random;

public class Clinica {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private String nomeClinica;
    private String endereco;

    private Medico listaMedicos[];
    private int listaMedicoIndex = 0;

    private Consulta listaConsultas[];
    private int listaConsultaIndex = 0;

    // Métados Especiais

    public Clinica(String nomeClinica, String endereco) {
        this.nomeClinica = nomeClinica;
        this.endereco = endereco;

        this.listaMedicos = new Medico[10];
        this.listaConsultas = new Consulta[10];
    }

    // Métados Especiais Gets e Sets

    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Medico[] getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(Medico[] listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public Consulta[] getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(Consulta[] listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    // Métados
    public boolean contratarMedico(Medico pMedico){

        if(this.listaMedicoIndex < 10){
            for(Medico medico : this.getListaMedicos() ) {
                if (medico.equals(pMedico)) return false;
            }

            this.listaMedicos[this.listaMedicoIndex] = pMedico;
            this.listaMedicoIndex++;

            return true;

        }

        return false;

    }

    public Medico BuscarMedico(int pCRM){
        for (Medico medico : this.getListaMedicos()) {
            if(medico.getCRM() == pCRM) return medico;
        }

        return null;
    }


    public int MarcarConsulta(Medico pMedico){
        if(this.listaConsultaIndex < 10){
            Random random = new Random();
            Consulta consulta = new Consulta( random.nextInt(20) , pMedico );

            this.listaConsultas[this.listaConsultaIndex] = consulta;
            this.listaConsultaIndex++;

            return consulta.getCodConsulta();
        }

        return -1;
    }

    public double pagarConsultar(int pCodConsulta){
        for (Consulta consulta: this.getListaConsultas()) {
            if(consulta.getCodConsulta() == pCodConsulta){
                return consulta.getMedicoResponsavel().totalConsulta(consulta.getTempo());
            }
        }

        return 0;
    }



}
