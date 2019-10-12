package CadastroEventos;

import java.util.Arrays;

public class Minicurso extends Evento{
    private  Participantes ministrantes[];
    private  String publicoAlvo;
    private  String metodologia;

    public Minicurso(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao, String publicoAlvo, String metodologia) {
        super(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
        this.publicoAlvo = publicoAlvo;
        this.metodologia = metodologia;
    }

    public Minicurso(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao, Participantes[] ministrantes, String publicoAlvo, String metodologia) {
        super(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
        this.ministrantes = ministrantes;
        this.publicoAlvo = publicoAlvo;
        this.metodologia = metodologia;
    }

    public Minicurso(Evento evento, String publicoAlvo, String metodologia) {
        super(evento.titulo, evento.resumo, evento.qtdMaximaDeParticipantes,evento.local,evento.horario,evento.duracao);
        this.publicoAlvo = publicoAlvo;
        this.metodologia = metodologia;
    }

    public boolean ministrantesTemProfessor(){
        try{
            for(Participantes x : this.ministrantes){
                if(x instanceof Professores){
                    return true;
                }
            }

            return false;
        }catch (NullPointerException ex){
            return false;
        }
    }

    public boolean cadastrarMinistrante(Participantes  participante){
        try{

            if(this.ministrantes.length < 2 && this.ministrantes != null){
                Participantes participantes[] = new Participantes[this.ministrantes.length+1];
                int qtd = 0;

                for(Participantes x : this.ministrantes){
                    participantes[qtd] = x;
                    qtd++;
                }
                participantes[this.ministrantes.length] = participante;
                this.ministrantes = participantes;

                return true;
            }else if(this.ministrantesTemProfessor() && this.ministrantes != null){
                Participantes participantes[] = new Participantes[this.ministrantes.length+1];
                int qtd = 0;

                for(Participantes x : this.ministrantes){
                    participantes[qtd] = x;
                    qtd++;
                }
                participantes[this.ministrantes.length] = participante;
                this.ministrantes = participantes;

                return true;
            }

            return false;

        }catch (NullPointerException ex){
            Participantes participantes[] = new Participantes[1];
            participantes[0] = participante;
            this.ministrantes = participantes;

            return true;
        }

    }
    public boolean removerMinistrante(Participantes ministrante){
        try{

            if(this.ministrantes.length > 0){
                Participantes participantes[] = new Participantes[this.ministrantes.length-1];
                int qtd = 0;

                for (Participantes x: this.ministrantes) {
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

        for (Participantes x: this.ministrantes) {
            str += x.getNome()+" ";
        }

        return str;
    }

    public Participantes[] getMinistrantes() {
        return ministrantes;
    }

    public void setMinistrantes(Participantes[] ministrantes) {
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
