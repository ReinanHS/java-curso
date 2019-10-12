package CadastroEventos;

import java.util.Arrays;

public class Alunos extends Participantes{
private String periodo;


    public Alunos(String matricula, String nome, int nivelEscolar, String curso, String instituicao, String periodo) {
        super(matricula, nome, nivelEscolar, curso, instituicao);
        this.periodo = periodo;
    }

    public Alunos(Participantes participante,String periodo) {
        super(participante.matricula, participante.nome, participante.nivelEscolar,participante.curso, participante.instituicao);
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "periodo='" + periodo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", nivelEscolar=" + nivelEscolar +
                ", curso='" + curso + '\'' +
                '}';
    }
}
