package br.semanaAcademica;

public class Evento {
    protected String titulo;
    protected String resumo;
    protected int qtdMaximaDeParticipnates;
    protected Participante participantes[];
    protected String local;
    protected String horario;
    protected double duracao;
    protected Recursos[] recursos;

    public Evento(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.qtdMaximaDeParticipnates = qtdMaximaDeParticipnates;
        //this.participantes = new Participante[qtdMaximaDeParticipnates];
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
        return qtdMaximaDeParticipnates;
    }

    public void setQtdMaximaDeParticipnates(int qtdMaximaDeParticipnates) {
        this.qtdMaximaDeParticipnates = qtdMaximaDeParticipnates;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participante[] participantes) {
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

    public Recursos[] getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos[] recursos) {
        this.recursos = recursos;
    }

    public String recursosToString(){
        String str = "";

        for (Recursos x: this.recursos) {
            str += x.getNome()+" ";
        }

        return str;
    }

    public boolean cadastroParticipantes(Participante participante){
        try{

            if(this.participantes.length <= this.getQtdMaximaDeParticipnates()){
                Participante participantes[] = new Participante[this.participantes.length+1];

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

        }catch(NullPointerException ex){
            Participante participantes[] = new Participante[1];
            participantes[0] = participante;

            this.participantes = participantes;

            return true;
        }
    }

    public boolean removerParticipantes(Participante participante){

        try{

            if(this.participantes.length > 0){
                Participante participantes[] = new Participante[this.participantes.length-1];
                int qtd = 0;

                for (Participante x: this.participantes ) {
                    if(!x.equals(participante)){
                        participantes[qtd] = x;
                        qtd++;
                    }
                }

                this.participantes = participantes;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }

    public boolean cadastroRecursos(Recursos recurso){
        try{

            Recursos recursos[] = new Recursos[this.recursos.length+1];

            for (int i = 0; i < this.recursos.length; i++) {
                recursos[i] = this.recursos[i];
            }

            recursos[this.recursos.length] = recurso;

            this.recursos = recursos;

            return true;

        }catch(NullPointerException ex){
            Recursos recursos[] = new Recursos[1];
            recursos[0] = recurso;

            this.recursos = recursos;

            return true;
        }
    }

    public boolean removerRecursos(Recursos recurso){

        try{

            if(this.recursos.length > 0){
                Recursos recursos[] = new Recursos[this.recursos.length-1];
                int qtd = 0;

                for (Recursos x: this.recursos ) {
                    if(!x.equals(recurso)){
                        recursos[qtd] = x;
                        qtd++;
                    }
                }

                this.recursos = recursos;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
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
}
