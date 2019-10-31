package Aulas.IntefaceGenerics;

public interface IRepositorio<G> {

    boolean inserir(G o);

    G buscar(int id);

    G remover(int id);

    G[] listar();
}
