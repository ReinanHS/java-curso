package Provas.MineProva;

import java.util.Random;

public class Cotacao {
    // Atributos
    private int Id;
	private Produto Produto;
	private int Qtd_Produtos;
	private String Data_Solicitacao;
	private String Nome_Solicitante;
	private Fornecedor Fornecedor;
	private Double ValorCotacao;
    // M�tados Especiais
    public Cotacao() {
        this.Id = (new Random().nextInt(10)+1) * (new Random().nextInt(10)+1);
    }

    public Cotacao(int id) {
        this.Id = id;
    }

    public Cotacao(int id, Produto produto, int qtd_Produtos, String data_Solicitacao, String nome_Solicitante, Fornecedor fornecedor, Double valorCotacao) {
        this.Id = id;
        this.Produto = produto;
        this.Qtd_Produtos = qtd_Produtos;
        this.Data_Solicitacao = data_Solicitacao;
        this.Nome_Solicitante = nome_Solicitante;
        this.Fornecedor = fornecedor;
        this.ValorCotacao = valorCotacao;
    }

    public Cotacao(Produto produto, int qtd_Produtos, String data_Solicitacao, String nome_Solicitante, Fornecedor fornecedor, Double valorCotacao) {
        this.Id = (new Random().nextInt(10)+1) * (new Random().nextInt(10)+1);
        this.Produto = produto;
        this.Qtd_Produtos = qtd_Produtos;
        this.Data_Solicitacao = data_Solicitacao;
        this.Nome_Solicitante = nome_Solicitante;
        this.Fornecedor = fornecedor;
        this.ValorCotacao = valorCotacao;
    }

    @Override
    public String toString() {
        return "Cotacao{" +
                "Id=" + Id +
                ", Produto=" + Produto +
                ", Qtd_Produtos=" + Qtd_Produtos +
                ", Data Da Solicitacao='" + Data_Solicitacao + '\'' +
                ", Nome Do Solicitante='" + Nome_Solicitante + '\'' +
                ", Fornecedor=" + Fornecedor +
                ", Valor Da Cotacao=" + ValorCotacao +
                '}';
    }

    // M�tados Especiais Gets e Sets

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto produto) {
        Produto = produto;
    }

    public int getQtdProdutos() {
        return Qtd_Produtos;
    }

    public void setQtdProdutos(int qtd_Produtos) {
        Qtd_Produtos = qtd_Produtos;
    }

    public String getData_Solicitacao() {
        return Data_Solicitacao;
    }

    public void setData_Solicitacao(String data_Solicitacao) {
        Data_Solicitacao = data_Solicitacao;
    }

    public String getNome_Solicitante() {
        return Nome_Solicitante;
    }

    public void setNome_Solicitante(String nome_Solicitante) {
        Nome_Solicitante = nome_Solicitante;
    }

    public Fornecedor getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        Fornecedor = fornecedor;
    }

    public Double getValorCotacao() {
        return ValorCotacao;
    }

    public void setValorCotacao(Double valorCotacao) {
        ValorCotacao = valorCotacao;
    }

    // M�tados
}
