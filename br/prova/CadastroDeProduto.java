package br.prova;

public class CadastroDeProduto {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos Júnio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private Produto produto[];
    private int qtdProdutos;
    private int produtoIndex = 0;
    // Métados Especiais

    public CadastroDeProduto(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
        this.produto = new Produto[qtdProdutos];
    }

    // Métados Especiais Gets e Sets

    public Produto[] getProduto() {
        return produto;
    }

    public void setProduto(Produto[] produto) {
        this.produto = produto;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    // Métados
    public boolean adicionarProduto(Produto produto){
        if(this.produtoIndex < this.getProduto().length){
            this.produto[this.produtoIndex] = produto;
            this.produtoIndex++;

            return true;
        }

        return false;
    }

    public Produto removerProduto(Produto produto){
        if(this.produtoIndex > 0){
            Produto lista[] = new Produto[this.getQtdProdutos()];
            int qtdLista = 0;

            for (int i = 0; i < lista.length; i++) {
                if(!this.getProduto()[i].equals(produto)){
                    lista[qtdLista] = this.getProduto()[i];
                    qtdLista++;
                }
            }

            this.setProduto(lista);
            this.produtoIndex--;

            return produto;
        }

        return null;
    }

    public Produto buscarProdutoPorId(int id){
        for (int i = 0; i < this.produtoIndex; i++) {
            if(this.getProduto()[i].id == id){
                return this.getProduto()[i];
            }
        }

        return null;
    }

    public Produto[] listarProdutos(){
        if(this.produtoIndex > 0){
            Produto lista[] = new Produto[this.produtoIndex];

            for (int i = 0; i < this.produtoIndex; i++) {
                lista[i] = this.getProduto()[i];
            }

            return lista;
        }

        return null;
    }

    public Produto[] listarProdutosDaPessoa(Pessoa pessoa){
        if(this.produtoIndex > 0){
            Produto lista[] = new Produto[this.produtoIndex];
            int index = 0;

            for (int i = 0; i < this.produtoIndex; i++) {
                if(this.getProduto()[i] instanceof Filme){
                    if( ((Filme) this.getProduto()[i]).temEssaPessoa(pessoa) ){
                        lista[index] = this.getProduto()[i];
                        index++;
                    }
                }else if(this.getProduto()[i] instanceof Livro){
                    if( ((Livro) this.getProduto()[i]).getAutor().equals(pessoa) ){
                        lista[index] = this.getProduto()[i];
                        index++;
                    }
                }
            }

            return (index > 0) ? lista : null;
        }

        return null;
    }

    public Produto[] listarLivrosDoAutor(Pessoa pessoa){
        if(this.produtoIndex > 0){
            Produto lista[] = new Produto[this.produtoIndex];
            int index = 0;

            for (int i = 0; i < this.produtoIndex; i++) {
                if(this.getProduto()[i] instanceof Livro){
                    if( ((Livro) this.getProduto()[i]).getAutor().equals(pessoa) ){
                        lista[index] = this.getProduto()[i];
                        index++;
                    }
                }
            }

            return (index > 0) ? lista : null;
        }

        return null;
    }

    public Produto[] listarLivrosDaEditorarNoPeriodo(String nome, int primeiroAno, int SegundoAno){
        if(this.produtoIndex > 0){
            Produto lista[] = new Produto[this.produtoIndex];
            int index = 0;

            for (int i = 0; i < this.produtoIndex; i++) {
                if(this.getProduto()[i] instanceof Livro){
                    Livro livro = ((Livro) this.getProduto()[i]);
                    if( livro.getEditora().equals(nome) && livro.getAnoDePublicacao() >= primeiroAno && livro.getAnoDePublicacao() <= SegundoAno ){
                        lista[index] = this.getProduto()[i];
                        index++;
                    }
                }
            }

            return (index > 0) ? lista : null;
        }

        return null;
    }

    public Produto[] listarFilmesDoAtorDaCategoriaDaClassificacao(Pessoa pessoa,String categoria, String classificacao){
        if(this.produtoIndex > 0){
            Produto lista[] = new Produto[this.produtoIndex];
            int index = 0;

            for (int i = 0; i < this.produtoIndex; i++) {
                if(this.getProduto()[i] instanceof Filme){
                    Filme filme = ((Filme) this.getProduto()[i]);
                    if( filme.getCategoria().equals(categoria) && filme.getClassificacao().equals(classificacao) && filme.temEssaPessoa(pessoa) ){
                        lista[index] = this.getProduto()[i];
                        index++;
                    }
                }
            }

            return (index > 0) ? lista : null;
        }

        return null;
    }


}
