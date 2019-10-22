package Aulas.Inteface;

import java.util.Arrays;

public class RepositorioDeProduto implements IRepositorio {
    private Produto[] produtos;
    private int qtdProdutos;

    public RepositorioDeProduto(int qtdProdutos) {
        this.produtos = new Produto[qtdProdutos];
    }

    @Override
    public boolean inserir(Object o) {
        if (!(o instanceof Produto))
            return false;

        if (qtdProdutos >= produtos.length)
            return false;

        produtos[qtdProdutos] = (Produto) o;
        qtdProdutos++;
        return true;
    }

    @Override
    public Object buscar(int id) {

        if(qtdProdutos == 0) return null;

        for(byte i = 0; i < qtdProdutos; i++){
            if (this.produtos[i].codigo == id ){
                return this.produtos[i];
            }
        }

        return null;
    }

    @Override
    public Object remover(int id) {

        if(qtdProdutos <= 0) return null;

        for(byte i = 0; i < qtdProdutos; i++){
            if (this.produtos[i].codigo == id ){

                Produto cache = this.produtos[i];

                this.produtos[i] = this.produtos[qtdProdutos-1];
                this.produtos[qtdProdutos-1] = null;
                this.qtdProdutos--;

                return cache;

            }

        }

        return null;
    }

    @Override
    public Object[] listar() {

        Produto produto[] = new Produto[this.qtdProdutos];

        for (int i = 0; i < qtdProdutos; i++) {
            for (int j = 0; j < qtdProdutos; j++) {
                if(this.produtos[i].codigo > this.produtos[j].codigo){
                    Produto cache = this.produtos[j];

                    this.produtos[j] = this.produtos[i];
                    this.produtos[i] = cache;

                    produto[j] = this.produtos[j];
                    produto[i] = cache;

                }

            }
        }

        return produto;
    }
}
