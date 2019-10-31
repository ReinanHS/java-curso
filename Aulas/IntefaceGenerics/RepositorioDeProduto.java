package Aulas.IntefaceGenerics;

public class RepositorioDeProduto extends AbsRepositorio<Produto> {

    @Override
    public Produto buscar(int id) {
        return null;
    }

    @Override
    public Produto remover(int id) {
        return null;
    }

    @Override
    protected boolean tipoCorreto(Object o) {
        return o instanceof Produto;
    }
}
