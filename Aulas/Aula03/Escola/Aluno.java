package Aulas.Aula03.Escola;

public class Aluno {
    public String matricula;
    public String nome;
    public String cpf;
    public String email;
    public Curso cursos;

    public void informarDados(String matricula, String nome, String cpf, String email, Curso cursos) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cursos = cursos;
    }

    public boolean matricular(){
        return true;
    }

    public void imprimirDados(String s, String jean_santos, String s1, String s2, Curso matematica){ System.out.println(this.toString()); }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
