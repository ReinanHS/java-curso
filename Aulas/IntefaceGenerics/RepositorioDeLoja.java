package Aulas.IntefaceGenerics;

public class RepositorioDeLoja extends AbsRepositorio<Loja> {

    @Override
    protected boolean tipoCorreto(Object o) {
        if (o instanceof Loja)
            return true;
        else
            return false;
    }

    @Override
    public Loja buscar(int id) {
        return null;
    }

    @Override
    public Loja remover(int id) {
        return null;
    }
}
