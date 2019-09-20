package renovese;

public class Cotacao {

    private int id;
    private Produto produto;
    private int qtdProduto;
    private String dataDaSolicitacao;
    private String nomeDoSolicitante;
    private Fornecedor fornecedor;

    public Cotacao(int id, Produto produto, int qtdProduto, String dataDaSolicitacao, String nomeDoSolicitante, Fornecedor fornecedor) {
        this.id = id;
        this.produto = produto;
        this.qtdProduto = qtdProduto;
        this.dataDaSolicitacao = dataDaSolicitacao;
        this.nomeDoSolicitante = nomeDoSolicitante;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getDataDaSolicitacao() {
        return dataDaSolicitacao;
    }

    public void setDataDaSolicitacao(String dataDaSolicitacao) {
        this.dataDaSolicitacao = dataDaSolicitacao;
    }

    public String getNomeDoSolicitante() {
        return nomeDoSolicitante;
    }

    public void setNomeDoSolicitante(String nomeDoSolicitante) {
        this.nomeDoSolicitante = nomeDoSolicitante;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double valorTotalDaCotacao() {
        return qtdProduto * produto.getValorUnitario();
    }

    @Override
    public String toString() {
        return "Cotacao [" + id + ", " + produto  + ", " + qtdProduto +
                 ", " + dataDaSolicitacao + ", " + nomeDoSolicitante  + ", " + fornecedor + "]";
    }

    @Override
    public boolean equals(Object o) {
        Cotacao c = (Cotacao) o;
        if (c == null)
            return false;
        if (this.getId() == c.getId())
            return true;
        return false;
    }
}
