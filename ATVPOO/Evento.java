package CadastroEventos;

import java.util.Arrays;

public class Evento {
	
    protected String titulo;
    protected String resumo;
    protected int qtdMaximaDeParticipantes;
    protected Participantes participantes[];
    protected String local;
    protected String horario;
    protected double duracao;
    protected Recurso[] recursos;

    public Evento(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.qtdMaximaDeParticipantes = qtdMaximaDeParticipnates;
        this.local = local;
        this.horario = horario;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQtdMaximaDeParticipnates() {
        return qtdMaximaDeParticipantes;
    }

    public void setQtdMaximaDeParticipnates(int qtdMaximaDeParticipnates) {
        this.qtdMaximaDeParticipantes = qtdMaximaDeParticipnates;
    }

    public Participantes[] getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participantes[] participantes) {
        this.participantes = participantes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Recurso[] getRecursos() {
        return recursos;
    }

    public void setRecursos(Recurso[] recursos) {
        this.recursos = recursos;
    }

    public String recursosToString(){
        String str = "";
        try{
            for (Recurso x: this.recursos) {
                str += x.getNome()+" ";
            }
        }catch (NullPointerException ex){
            str = "O recurso não foi cadastrado";
        }
        return str;
    }

    public boolean cadastroParticipantes(Participantes participante){
        try{

            if(this.participantes.length <= this.getQtdMaximaDeParticipnates()){
                Participantes participantes[] = new Participantes[this.participantes.length+1];
                for (int i = 0; i < this.participantes.length; i++) {
                    if(!this.participantes[i].equals(participante)){
                        participantes[i] = this.participantes[i];
                    }else return false;
                }
                participantes[this.participantes.length] = participante;
                this.participantes = participantes;
                return true;
            }
            return false;
        }catch(NullPointerException exe){
            Participantes participantes[] = new Participantes[1];
            participantes[0] = participante;
            this.participantes = participantes;
            return true;
        }
    }

    public boolean removerParticipantes(Participantes participante){

        try{

            if(this.participantes.length > 0){
                Participantes participantes[] = new Participantes[this.participantes.length-1];
                int qtd = 0;

                for (Participantes x: this.participantes ) {
                    if(!x.equals(participante)){
                        participantes[qtd] = x;
                        qtd++;
                    }
                }
                this.participantes = participantes;
                return true;
            }
            return false;
        }catch (NullPointerException exe){
            return false;
        }
    }

    public boolean cadastrodeRecursos(Recurso recurso){
        try{

            Recurso recursos[] = new Recurso[this.recursos.length+1];

            for (int i = 0; i < this.recursos.length; i++) {
                recursos[i] = this.recursos[i];
            }
            recursos[this.recursos.length] = recurso;
            this.recursos = recursos;
            return true;
        }catch(NullPointerException exe){
            Recurso recursos[] = new Recurso[1];
            recursos[0] = recurso;
            this.recursos = recursos;
            return true;
        }
    }

    public boolean removerRecursos(Recurso recurso){

        try{
            if(this.recursos.length > 0){
                Recurso recursos[] = new Recurso[this.recursos.length-1];
                int qtd = 0;
                for (Recurso x: this.recursos ) {
                    if(!x.equals(recurso)){
                        recursos[qtd] = x;
                        qtd++;
                    }
                }
                this.recursos = recursos;
                return true;
            }
            return false;
        }catch (NullPointerException exe){
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Evento ){
            Evento objNovo = (Evento) obj;
            if( objNovo.getTitulo().equals(this.getTitulo()) ){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", qtdMaximaDeParticipnates=" + qtdMaximaDeParticipantes +
                ", participantes=" + Arrays.toString(participantes) +
                ", local='" + local + '\'' +
                ", horario='" + horario + '\'' +
                ", duracao=" + duracao +
                ", recursos=" + Arrays.toString(recursos) +
                '}';
    }
}
