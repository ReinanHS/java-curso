package br.semanaAcademica;

import java.util.Arrays;

public class Minicurso extends Evento{
    private  Participante ministrantes[];
    private  String publicoAlvo;
    private  String metodologia;

    public Minicurso(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao, String publicoAlvo, String metodologia) {
        super(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
        this.publicoAlvo = publicoAlvo;
        this.metodologia = metodologia;
    }

    public Minicurso(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao, Participante[] ministrantes, String publicoAlvo, String metodologia) {
        super(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
        this.ministrantes = ministrantes;
        this.publicoAlvo = publicoAlvo;
        this.metodologia = metodologia;
    }

    public boolean ministrantesTemProfessor(){
        try{
            for(Participante x : this.ministrantes){
                if(x instanceof Professor){
                    return true;
                }
            }

            return false;
        }catch (NullPointerException ex){
            return false;
        }
    }

    public boolean cadastrarMinistrante(Participante  participante){
        try{

            if(this.ministrantes.length < 2 && this.ministrantes != null){
                Participante participantes[] = new Participante[this.ministrantes.length+1];
                int qtd = 0;

                for(Participante x : this.ministrantes){
                    participantes[qtd] = x;
                    qtd++;
                }
                participantes[this.ministrantes.length] = participante;
                this.ministrantes = participantes;

                return true;
            }else if(this.ministrantesTemProfessor() && this.ministrantes != null){
                Participante participantes[] = new Participante[this.ministrantes.length+1];
                int qtd = 0;

                for(Participante x : this.ministrantes){
                    participantes[qtd] = x;
                    qtd++;
                }
                participantes[this.ministrantes.length] = participante;
                this.ministrantes = participantes;

                return true;
            }

            return false;

        }catch (NullPointerException ex){
            Participante participantes[] = new Participante[1];
            participantes[0] = participante;
            this.ministrantes = participantes;

            return true;
        }

    }
    public boolean removerMinistrante(Participante ministrante){
        try{

            if(this.ministrantes.length > 0){
                Participante participantes[] = new Participante[this.ministrantes.length-1];
                int qtd = 0;

                for (Participante x: this.ministrantes) {
                    if(!x.equals(ministrante)){
                        participantes[qtd] = x;
                        qtd++;
                    }
                }

                this.ministrantes = participantes;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }

    public String ministrantesToString(){

        String str = "";

        for (Participante x: this.ministrantes) {
            str += x.getNome()+" ";
        }

        return str;
    }

    public Participante[] getMinistrantes() {
        return ministrantes;
    }

    public void setMinistrantes(Participante[] ministrantes) {
        this.ministrantes = ministrantes;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Minicurso ){

            Minicurso objNovo = (Minicurso) obj;

            if( objNovo.getTitulo().equals(this.getTitulo()) ){
                return true;
            }

            return false;
        }

        return false;
    }
}
