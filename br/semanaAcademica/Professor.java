package br.semanaAcademica;

public class Professor extends Participante{
    private String cpf;
    private String instituicao;
    private int rg;

    public Professor(String matricula, String nome, int nivelEscolar, String curso, String cpf, String instituicao, int rg) {
        super(matricula, nome, nivelEscolar, curso);
        this.cpf = cpf;
        this.instituicao = instituicao;
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
