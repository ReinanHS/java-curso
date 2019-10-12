package br.semanaAcademica;

import java.util.Arrays;

public class GerenciarEventos {
    private Participante Participantes[];
    private Evento Eventos[];
    private Recursos Recursos[];

    public GerenciarEventos() { }

    public boolean cadastrarPartipantes(Participante  participante){
        try{

            Participante participantes[] = new Participante[this.Participantes.length+1];

            for (int i = 0; i < this.Participantes.length; i++) {
                if(!this.Participantes[i].equals(participante)){
                    participantes[i] = this.Participantes[i];
                }else return false;
            }

            participantes[this.Participantes.length] = participante;

            this.Participantes = participantes;

            return true;

        }catch(NullPointerException ex){
            Participante participantes[] = new Participante[1];
            participantes[0] = participante;

            this.Participantes = participantes;

            return true;
        }
    }

    public boolean removerParticipante(Participante participante){

        try{

            if(this.Participantes.length > 0){
                Participante participantes[] = new Participante[this.Participantes.length-1];
                int qtd = 0;

                for (Participante x: this.Participantes ) {
                    if(!x.equals(participante)){
                        participantes[qtd] = x;
                        qtd++;
                    }
                }

                this.Participantes = participantes;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }

    public String listarParticipantesToString(){

        String listagem = "";

        try{
            for(Participante y: this.Participantes){
                listagem += "Matricula: ["+y.getMatricula()+"]\n";
                listagem += "Nome: ["+y.getNome()+"]\n";
                listagem += "Curso: ["+y.getCurso()+"]\n";
                listagem += "Instituição: ["+y.getInstituicao()+"]\n\n";
            }
        }catch (NullPointerException ex){
            listagem = "Não tem participantes";
        }

        return listagem;
    }

    public boolean cadastroDeRecursos(Recursos recurso){
        try{

            Recursos recursos[] = new Recursos[this.Recursos.length+1];

            for (int i = 0; i < this.Recursos.length; i++) {
                recursos[i] = this.Recursos[i];
            }

            recursos[this.Recursos.length] = recurso;
            this.Recursos = recursos;

            return true;

        }catch(NullPointerException ex){
            Recursos recursos[] = new Recursos[1];
            recursos[0] = recurso;

            this.Recursos = recursos;

            return true;
        }
    }

    public boolean removerRecurso(Recursos recurso){

        try{

            if(this.Recursos.length > 0){
                Recursos recursos[] = new Recursos[this.Recursos.length-1];
                int qtd = 0;

                for (Recursos x: this.Recursos ) {
                    if(!x.equals(recurso)){
                        recursos[qtd] = x;
                        qtd++;
                    }
                }

                this.Recursos = recursos;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }

    public String listarRecurosToString(){

        String listagem = "";

        try{
            for(Recursos y: this.Recursos){
                listagem += "Código: ["+y.getCodigo()+"]\n";
                listagem += "Nome: ["+y.getNome()+"]\n";
                listagem += "Descrição: ["+y.getDescricao()+"]\n";
                listagem += "Quantitativo de vagas: ["+y.getQuantitativo()+"]\n\n";
            }
        }catch (NullPointerException ex){
            listagem = "Não tem Recusos";
        }

        return listagem;
    }


    public boolean cadastroDeEventos(Evento evento){
        try{

            Evento eventos[] = new Evento[this.Eventos.length+1];

            for (int i = 0; i < this.Eventos.length; i++) {
                eventos[i] = this.Eventos[i];
            }

            eventos[this.Eventos.length] = evento;
            this.Eventos = eventos;

            return true;

        }catch(NullPointerException ex){
            Evento eventos[] = new Evento[1];
            eventos[0] = evento;

            this.Eventos = eventos;

            return true;
        }
    }

    public boolean removerEventos(Evento evento){

        try{

            if(this.Eventos.length > 0){
                Evento eventos[] = new Evento[this.Eventos.length-1];
                int qtd = 0;

                for (Evento x: this.Eventos ) {
                    if(!x.equals(evento)){
                        eventos[qtd] = x;
                        qtd++;
                    }
                }

                this.Eventos = eventos;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }

    public Palestra[] listarPalestrar(){

        Palestra palestras[] = new Palestra[this.getTamanhoPalestra()];
        int qtdPalestras = 0;

        try{
            for(Evento y: this.Eventos){
                if(y instanceof Palestra){
                    palestras[qtdPalestras]= (Palestra) y;
                    qtdPalestras++;
                }
            }

            return palestras;
        }catch (NullPointerException ex){
            return null;
        }
    }

    public String listarPalestrarToString(){

        Palestra palestras[] = new Palestra[this.getTamanhoPalestra()];
        String listagem = "";

        try{
            for(Evento y: this.Eventos){
                if(y instanceof Palestra){

                    Palestra u = ((Palestra) y);

                    listagem += "Palestrante: ["+u.getPalestrante()+"]\n";
                    listagem += "Publico Alvo: ["+u.getPublicoAlvo()+"]\n";
                    listagem += "Metodologia: ["+u.getMetodologia()+"]\n";
                    listagem += "Recursos: ["+u.recursosToString()+"]\n\n";

                }
            }
        }catch (NullPointerException ex){
            listagem = "Não tem palestra no vetor";
        }

        return listagem;
    }


    public Minicurso[] listarMinicursos(){

        Minicurso minicursos[] = new Minicurso[this.getTamanhoMinicurso()];
        int qtdPalestras = 0;

        try{
            for(Evento y: this.Eventos){
                if(y instanceof Minicurso){
                    minicursos[qtdPalestras]= (Minicurso) y;
                    qtdPalestras++;
                }
            }

            return minicursos;
        }catch (NullPointerException ex){
            return null;
        }
    }

    protected int getTamanhoPalestra(){

        int qtdTotal = 0;

        try{
            for(Evento x : this.Eventos){
                if(x instanceof Palestra){
                    qtdTotal++;
                }
            }
        }catch (NullPointerException ex){
            return 0;
        }

        return qtdTotal;
    }

    public String listarMinicursosToString(){

        Minicurso minicursos[] = new Minicurso[this.getTamanhoMinicurso()];
        String listagem = "";

        try{
            for(Evento y: this.Eventos){
                if(y instanceof Minicurso){

                    Minicurso u = ((Minicurso) y);

                    listagem += "Ministrantes: ["+u.ministrantesToString()+"]\n";
                    listagem += "Publico Alvo: ["+u.getPublicoAlvo()+"]\n";
                    listagem += "Metodologia: ["+u.getMetodologia()+"]\n";
                    listagem += "Recursos: ["+u.recursosToString()+"]\n\n";

                }
            }
        }catch (NullPointerException ex){
            listagem = "Não tem Mini Cursos no vetor";
        }

        return listagem;
    }

    public String listarEventosToString(){

        String listagem = "";

        try {
            for(Evento y: this.Eventos){
                listagem += "Titulo: ["+y.getTitulo()+"]\n";
                listagem += "Resumo: ["+y.getResumo()+"]\n";
                listagem += "Recursos: ["+y.recursosToString()+"]\n";
                if(y instanceof Palestra){
                    listagem += "Tipo: [Palestra]\n";
                }else if(y instanceof Minicurso){
                    listagem += "Tipo: [Minicurso]\n";
                }else{
                    listagem += "Tipo: [Evento]\n";
                }
            }
        }catch (NullPointerException ex){
            listagem = "Não foi cadastrado";
        }

        return listagem;
    }

    public Evento[] listarEventos(){
        return this.Eventos;
    }

    protected int getTamanhoMinicurso(){

        int qtdTotal = 0;

        for(Evento x : this.Eventos){
            if(x instanceof Minicurso){
                qtdTotal++;
            }
        }

        return qtdTotal;
    }

    public Participante[] getParticipantes() {
        return Participantes;
    }

    public void setParticipantes(Participante[] participantes) {
        Participantes = participantes;
    }

    public Evento[] getEventos() {
        return Eventos;
    }

    public void setEventos(Evento[] eventos) {
        Eventos = eventos;
    }

    public Recursos[] getRecursos() {
        return Recursos;
    }

    public void setRecursos(Recursos[] recursos) {
        Recursos = recursos;
    }
}
