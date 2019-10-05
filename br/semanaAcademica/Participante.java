package br.semanaAcademica;

public class Participante {
    protected String matricula;
    protected String nome;
    protected int nivelEscolar;
    protected String curso;

    public Participante(String matricula, String nome, int nivelEscolar, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.nivelEscolar = nivelEscolar;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(int nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", nivelEscolar=" + nivelEscolar +
                ", curso='" + curso + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Participante){

            Participante obgNovo = (Participante) obj;

            if(obgNovo.matricula.equals(this.matricula) == true){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
}
