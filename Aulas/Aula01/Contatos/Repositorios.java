package Aulas.Aula01.Contatos;

public interface Repositorios {
    void Adicionar(int index);
    void Buscar(String busca);
    void Listar(int min, int max);
    void Listar();
    void Remover(String busca);
}
