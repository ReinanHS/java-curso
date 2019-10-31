package Aulas.IntefaceGenerics;

public class RepositorioDeEvento extends AbsRepositorio<Evento> {
    @Override
    protected boolean tipoCorreto(Object o) {
        return o instanceof Evento;
    }

    @Override
    public Evento remover(int id) {
        return null;
    }
}
