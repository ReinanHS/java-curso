package Provas.MineProva;

import java.util.Arrays;

public class Orcamento {
    // Atributos
    private String Nome_Obra;
	private String Descricao_Reforma;
	private Cotacao Lista_Cotacoes[];
    // Métados Especiais
    public Orcamento() { }

    public Orcamento(String nome_Obra, String descricao_Reforma) {
        this.Nome_Obra = nome_Obra;
        this.Descricao_Reforma = descricao_Reforma;
    }

    public Orcamento(String nome_Obra, String descricao_Reforma, Cotacao[] lista_Cotacoes) {
        this.Nome_Obra = nome_Obra;
        this.Descricao_Reforma = descricao_Reforma;
        this.Lista_Cotacoes = lista_Cotacoes;
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "Nome Da Obra='" + Nome_Obra + '\'' +
                ", Descricao Da Reforma='" + Descricao_Reforma + '\'' +
                ", Lista De Cotacoes=" + Arrays.toString(Lista_Cotacoes) +
                '}';
    }

    // Métados Especiais Gets e Sets

    public String getNomeObra() {
        return Nome_Obra;
    }

    public void setNomeObra(String nome_Obra) {
        Nome_Obra = nome_Obra;
    }

    public String getDescricaoReforma() {
        return Descricao_Reforma;
    }

    public void setDescricaoReforma(String descricao_Reforma) {
        Descricao_Reforma = descricao_Reforma;
    }

    public Cotacao[] getListaCotacoes() {
        return Lista_Cotacoes;
    }

    public void setListaCotacoes(Cotacao[] lista_Cotacoes) {
        Lista_Cotacoes = lista_Cotacoes;
    }

    // Métados
    public boolean CadastrarCotacao(Cotacao cotacao){

        try {

            Cotacao cotacaos[] = new Cotacao[this.getListaCotacoes().length+1];
            for (int i = 0; i < this.getListaCotacoes().length; i++) {
                if(this.getListaCotacoes()[i] != cotacao){
                    cotacaos[i] = this.getListaCotacoes()[i];
                }else{ return false; }
            }

            cotacaos[this.getListaCotacoes().length] = cotacao;

            this.setListaCotacoes(cotacaos);

            return true;


        }catch (NullPointerException ex){

            // Caso o vetor não tenha sido inicializado retornaremos falso
            // Iremos criar um vetor com 1 elemento
            Cotacao cotacaos[] = new Cotacao[1];
            cotacaos[0] = cotacao;

            this.setListaCotacoes(cotacaos);

            return true;
        }
    }

    public Cotacao ObterCotacaoMenorValor(){

        int indexMaior = 0;

        for (int i = 0; i < this.getListaCotacoes().length; i++) {
            if(this.getListaCotacoes()[indexMaior].getValorCotacao() > this.getListaCotacoes()[i].getValorCotacao()){
                indexMaior = i;
            }
        }

        return this.getListaCotacoes()[indexMaior];
    }

    public Cotacao[] BuscarCotacaoPorFornecedor(Fornecedor fornecedor){
        int qtd = 0;

        try {
            for (int i = 0; i < this.getListaCotacoes().length; i++) {
                if(this.getListaCotacoes()[i].getFornecedor() == fornecedor){
                    qtd++;
                }
            }
        }catch (NullPointerException ex){ return null; }

        if(qtd > 0){

            Cotacao cotacaoFornecedor[] = new Cotacao[qtd];
            int index = 0;

            for (int i = 0; i < this.getListaCotacoes().length; i++) {
                if(this.getListaCotacoes()[i].getFornecedor() == fornecedor){
                    cotacaoFornecedor[index] = this.getListaCotacoes()[i];
                }
            }

            return cotacaoFornecedor;
        }

        return null;
    }

    public String ListarCotacaoes(){
        String mgs = "";

        for (int i = 0; i < this.getListaCotacoes().length; i++) {
            mgs += "ID: "+this.getListaCotacoes()[i].getId()+"\n";
            mgs += "Fornecedor: "+this.getListaCotacoes()[i].getFornecedor().getNome()+" - ID: "+this.getListaCotacoes()[i].getFornecedor().getId()+"\n";
            mgs += "Produto: "+this.getListaCotacoes()[i].getProduto().getNome()+"\n";
            mgs += "Valor Cotação: R$"+String.format("%.2f",this.getListaCotacoes()[i].getValorCotacao())+"\n";
            mgs += "Qtd Produtos: "+this.getListaCotacoes()[i].getQtdProdutos()+"\n\n";
        }

        return mgs;
    }

    public String ListarCotacaoes(Double mairValor){
        String mgs = "";

        for (int i = 0; i < this.getListaCotacoes().length; i++) {
            if(this.getListaCotacoes()[i].getValorCotacao() <= mairValor){
                mgs += "ID: "+this.getListaCotacoes()[i].getId()+"\n";
                mgs += "Fornecedor: "+this.getListaCotacoes()[i].getFornecedor().getNome()+"\n";
                mgs += "Produto: "+this.getListaCotacoes()[i].getProduto().getNome()+"\n";
                mgs += "Valor Cotação: - "+String.format("%.2f",this.getListaCotacoes()[i].getValorCotacao())+"\n";
                mgs += "Qtd Produtos: "+this.getListaCotacoes()[i].getQtdProdutos()+"\n\n";
            }
        }

        return mgs;
    }

    public String ListarCotacaoes(Double menorValor,Double mairValor){
        String mgs = "";

        for (int i = 0; i < this.getListaCotacoes().length; i++) {
            if(this.getListaCotacoes()[i].getValorCotacao() > menorValor && this.getListaCotacoes()[i].getValorCotacao() <= mairValor){
                mgs += "ID: "+this.getListaCotacoes()[i].getId()+"\n";
                mgs += "Fornecedor: "+this.getListaCotacoes()[i].getFornecedor().getNome()+"\n";
                mgs += "Produto: "+this.getListaCotacoes()[i].getProduto().getNome()+"\n";
                mgs += "Valor Cotação: - "+String.format("%.2f",this.getListaCotacoes()[i].getValorCotacao())+"\n";
                mgs += "Qtd Produtos: "+this.getListaCotacoes()[i].getQtdProdutos()+"\n\n";
            }
        }

        return mgs;
    }

}
