package br.semanaAcademica;

public class Professor extends Participante{
    private String cpf;
    private int rg;

    public Professor(String matricula, String nome, int nivelEscolar, String curso, String instituicao, String cpf, int rg) {
        super(matricula, nome, nivelEscolar, curso, instituicao);
        this.cpf = cpf;
        this.rg = rg;
    }

    public Professor(Participante participante,String cpf, int rg) {
        super(participante.matricula, participante.nome, participante.nivelEscolar, participante.curso, participante.instituicao);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + cpf + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", rg=" + rg +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", nivelEscolar=" + nivelEscolar +
                ", curso='" + curso + '\'' +
                '}';
    }
}
