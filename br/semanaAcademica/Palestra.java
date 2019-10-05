package br.semanaAcademica;

import java.util.Arrays;

public class Palestra extends Evento{

    private Participante palestrante;
    private String publicoAlvo;
    private String metodologia;


    public Palestra(String titulo, String resumo, int qtdMaximaDeParticipnates, String local, String horario, double duracao, Participante palestrante, String publicoAlvo, String metodologia) {
        super(titulo, resumo, qtdMaximaDeParticipnates, local, horario, duracao);
        this.palestrante = palestrante;
        this.publicoAlvo = publicoAlvo;
        this.metodologia = metodologia;
    }

    public Participante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Participante palestrante) {
        this.palestrante = palestrante;
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
    public String toString() {
        return "Palestra{" +
                "palestrante=" + palestrante +
                ", publicoAlvo='" + publicoAlvo + '\'' +
                ", metodologia='" + metodologia + '\'' +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", qtdMaximaDeParticipnates=" + qtdMaximaDeParticipnates +
                ", participantes=" + Arrays.toString(participantes) +
                ", local='" + local + '\'' +
                ", horario='" + horario + '\'' +
                ", duracao=" + duracao +
                ", recursos=" + Arrays.toString(recursos) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Palestra ){

            Palestra objNovo = (Palestra) obj;

            if( objNovo.getTitulo().equals(this.getTitulo()) ){
                return true;
            }

            return false;
        }

        return false;
    }
}
