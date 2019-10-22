package Aulas.Inteface;

import java.util.Random;

public class Produto {
    public int codigo;
    public String nome;

    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Produto(String nome) {

        Random random = new Random();

        this.codigo = random.nextInt(900);
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
        "codigo=" + codigo +
        ", nome='" + nome + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Produto){
            return ((Produto)obj).codigo == this.codigo;
        }

        return false;
    }
}
