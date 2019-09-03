package Aulas.Aula01.Contatos;

public class Contato {
    private String nome;
    private int idade;
    private int telefone;

//    public Contato(String nome, int idade, int telefone) {
//        this.nome = nome;
//        this.idade = idade;
//        this.telefone = telefone;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
