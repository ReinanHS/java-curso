package Aulas.Inteface;

public interface IRepositorio {
    boolean inserir(Object o);

    Object buscar(int id);

    Object remover(int id);

    Object[] listar();
}
