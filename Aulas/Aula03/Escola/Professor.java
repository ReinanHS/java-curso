package Aulas.Aula03.Escola;

public class Professor {
    public String matricula;
    public String nome;
    public String cpf;
    public String admissao;
    public String email;
    public Curso lotacao;

    public void informarDados(String matricula, String nome, String cpf, String admissao, String email, Curso lotacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.admissao = admissao;
        this.email = email;
        this.lotacao = lotacao;
    }

    public void imprimirDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", admissao='" + admissao + '\'' +
                ", email='" + email + '\'' +
                ", lotacao=" + lotacao +
                '}';
    }
}
