package br.semanaAcademica;

import java.util.Arrays;

public class GerenciarEventos {
    private Participante Participantes[];
    private Evento Eventos[];

    public GerenciarEventos() { }

    public boolean cadastrarPartipantes(Participante  participante){
        try{

            Participante participantes[] = new Participante[this.Participantes.length+1];

            for (int i = 0; i < this.Participantes.length; i++) {
                participantes[i] = this.Participantes[i];
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

        for(Evento y: this.Eventos){
            if(y instanceof Palestra){
                palestras[qtdPalestras]= (Palestra) y;
                qtdPalestras++;
            }
        }

        return palestras;
    }

    public String listarPalestrarToString(){

        Palestra palestras[] = new Palestra[this.getTamanhoPalestra()];
        String listagem = "";

        for(Evento y: this.Eventos){
            if(y instanceof Palestra){

                Palestra u = ((Palestra) y);

                listagem += "Palestrante: ["+u.getPalestrante()+"]";
                listagem += "Publico Alvo: ["+u.getPublicoAlvo()+"]";
                listagem += "Metodologia: ["+u.getMetodologia()+"]";
                listagem += "Recursos: ["+u.recursosToString()+"]";

            }
        }

        return listagem;
    }


    public Minicurso[] listarMinicursos(){

        Minicurso minicursos[] = new Minicurso[this.getTamanhoMinicurso()];
        int qtdPalestras = 0;

        for(Evento y: this.Eventos){
            if(y instanceof Minicurso){
                minicursos[qtdPalestras]= (Minicurso) y;
                qtdPalestras++;
            }
        }

        return minicursos;
    }

    public String listarMinicursosToString(){

        Minicurso minicursos[] = new Minicurso[this.getTamanhoMinicurso()];
        String listagem = "";

        for(Evento y: this.Eventos){
            if(y instanceof Minicurso){

                Minicurso u = ((Minicurso) y);

                listagem += "Ministrantes: ["+u.ministrantesToString()+"]";
                listagem += "Publico Alvo: ["+u.getPublicoAlvo()+"]";
                listagem += "Metodologia: ["+u.getMetodologia()+"]";
                listagem += "Recursos: ["+u.recursosToString()+"]";

            }
        }

        return listagem;
    }

    public Evento[] listarEventos(){
        return this.Eventos;
    }

    protected int getTamanhoPalestra(){

        int qtdTotal = 0;

        for(Evento x : this.Eventos){
            if(x instanceof Palestra){
                qtdTotal++;
            }
        }

        return qtdTotal;
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
}
