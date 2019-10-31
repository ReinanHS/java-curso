package Aulas.IntefaceGenerics;

public class Produto {

    private int id;
    private String nome;

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Produto){
            return this.id == ((Produto)obj).id;
        }else if(obj instanceof Integer) {
            return this.id == ((Integer)obj);
        }

        return false;
    }
}
