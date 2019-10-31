package Aulas.IntefaceGenerics;

public abstract class AbsRepositorio<T> implements IRepositorio<T> {

    private T[] objectos;
    private int qtdObjetos;

    public AbsRepositorio() {
        this.objectos = (T[]) new Object[5];
    }

    protected abstract boolean tipoCorreto(Object o);

    @Override
    public boolean inserir(T o) {
        if (!tipoCorreto(o))
            return false;

        if (qtdObjetos >= objectos.length)
            return false;

        objectos[qtdObjetos] = o;
        qtdObjetos++;
        return true;
    }

    @Override
    public T buscar(int id) {

        for (int i = 0; i < this.qtdObjetos; i++) {

            if( ((T) this.objectos[i]).equals(id) ){
                return ((T) this.objectos[i]);
            }
        }

        return null;
    }

    @Override
    public T remover(int id) {
        if(this.qtdObjetos <= 0) return null;

        for(byte i = 0; i < this.qtdObjetos; i++){
            if ( ((T)this.objectos[i]).equals(id) ){

                T cache = ((T)this.objectos[i]);

                this.objectos[i] = this.objectos[this.qtdObjetos-1];
                this.objectos[this.qtdObjetos-1] = null;
                this.qtdObjetos--;

                return cache;

            }

        }

        return null;
    }

    @Override
    public T[] listar() {
        return (T[]) this.objectos;
    }
}
