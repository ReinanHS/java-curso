package Aulas.IntefaceGenerics;

public class Loja {

    private int id;
    private String nome;
    private String local;

    public Loja(int id, String nome, String local) {
        this.id = id;
        this.nome = nome;
        this.local = local;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Loja){
            return this.id == ((Loja)obj).id;
        }else if(obj instanceof Integer) {
            return this.id == ((Integer)obj);
        }

        return false;
    }
}
