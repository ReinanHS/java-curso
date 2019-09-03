package Provas.MineProva;

import java.util.Arrays;
import java.util.Random;

public class Fornecedor {
    // Atributos //
    private int Id;
    private String Nome;
    private Produto[] Produtos;
    // Métados Especiais

    public Fornecedor() {
        // Caso não seja definido pelo construct um id para o fornecedor isso sera feito automaticamente
        this.Id = (new Random().nextInt(10)+1) * (new Random().nextInt(10)+1);
    }

    public Fornecedor(int id) {
        this.Id = id;
    }

    public Fornecedor(String nome) {
        this.Id = (new Random().nextInt(10)+1) * (new Random().nextInt(10)+1);
        this.Nome = nome;
    }

    public Fornecedor(int id, String nome) {
        this.Id = id;
        this.Nome = nome;
    }

    public Fornecedor(int id, String nome, Produto[] produtos) {
        this.Id = id;
        this.Nome = nome;
        this.Produtos = produtos;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Produtos=" + Arrays.toString(Produtos) +
                '}';
    }

    // Métados Especiais Gets e Sets

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public Produto[] getProdutos() {
        return this.Produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.Produtos = produtos;
    }

    // Métados
    public boolean CadastrarProduto(Produto produto){

        try {

            Produto produtos[] = new Produto[this.getProdutos().length+1];
            for (int i = 0; i < this.getProdutos().length; i++) {
                if(this.getProdutos()[i] != produto && this.getProdutos()[i].getId() != produto.getId()){
                    produtos[i] = this.getProdutos()[i];
                }else{ return false; }
            }

            produtos[this.getProdutos().length] = produto;

            this.setProdutos(produtos);

            return true;


        }catch (NullPointerException ex){

            // Caso o vetor não tenha sido inicializado retornaremos falso
            // Iremos criar um vetor com 1 elemento
            Produto produtos[] = new Produto[1];
            produtos[0] = produto;

            this.setProdutos(produtos);

            return true;
        }
    }

    public boolean RemoverProduto(Produto produto){

        try {

            if(this.getProdutos().length > 1){
                Produto produtos[] = new Produto[this.getProdutos().length-1];

                int index = 0;
                boolean achou = false;

                // Busca do produto pelo vetor para deletar
                for (int i = 0; i < this.getProdutos().length; i++) {
                    if(this.getProdutos()[i] != produto){
                        produtos[index] = this.getProdutos()[i];
                        index++;
                    }else{
                        achou = true;
                    }
                }

                // Caso o Produto seja encontrado no vetor removeremos ele e depois retonaremos true
                if(achou){
                    this.setProdutos(produtos);
                    return true;
                }

                return false;

            }else if(this.getProdutos()[1] == produto){
                // Caso o vetor só tenha um elemento então comparamos para remover ele do vetor
                this.setProdutos(new Produto[0]);
                return true;
            }

            // Não encontramos o Produto no vetor então retornaremos false
            return false;


        }catch (NullPointerException ex){
            // Caso o vetor não tenha sido inicializado retornaremos falso
            return false;
        }
    }

    public boolean RemoverProdutoPeloId(int id){

        try {

            if(this.getProdutos().length > 1){
                Produto produtos[] = new Produto[this.getProdutos().length-1];

                int index = 0;
                boolean achou = false;

                // Busca do produto pelo vetor para deletar
                for (int i = 0; i < this.getProdutos().length; i++) {
                    if(this.getProdutos()[i].getId() != id){
                        produtos[index] = this.getProdutos()[i];
                        index++;
                    }else{
                        achou = true;
                    }
                }

                // Caso o Produto seja encontrado no vetor removeremos ele e depois retonaremos true
                if(achou){
                    this.setProdutos(produtos);
                    return true;
                }

                return false;

            }else if(this.getProdutos()[1].getId() == id){
                // Caso o vetor só tenha um elemento então comparamos para remover ele do vetor
                this.setProdutos(new Produto[0]);
                return true;
            }

            // Não encontramos o Produto no vetor então retornaremos false
            return false;


        }catch (NullPointerException ex){
            // Caso o vetor não tenha sido inicializado retornaremos falso
            return false;
        }
    }

}
