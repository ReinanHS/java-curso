package renovese;

public class Orcamento {

    private String nome;
    private String descricao;
    private Cotacao[] cotacoes;
    private int qtdCotacoes;

    public Orcamento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.cotacoes = new Cotacao[5];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean addCotacao(Cotacao cotacao) {
        if (qtdCotacoes >= cotacoes.length)
            return false;

        cotacoes[qtdCotacoes] = cotacao;
        qtdCotacoes++;
        return true;
    }

    public Cotacao getCotacao(Cotacao cotacao) {
        for (int i = 0; i < qtdCotacoes; i++)
            if (cotacoes[i].equals(cotacao))
                return cotacoes[i];

        return null;
    }

    public Cotacao[] listarCotacoesPorFaixaDePreco(double valorMinimo, double valorMaximo) {
        Cotacao[] auxiliar = new Cotacao[qtdCotacoes];
        int qtdAuxiliar = 0;

        for (int i = 0; i < qtdCotacoes; i++) {
            double valor = cotacoes[i].valorTotalDaCotacao();
            if ((valor >= valorMinimo) && (valor <= valorMaximo)) {
                auxiliar[qtdAuxiliar] = cotacoes[i];
                qtdAuxiliar++;
            }
        }

        if (qtdAuxiliar > 0)
            return auxiliar;
        else
            return null;
    }


    public Cotacao[] listarCotacoesDeProdutosNacionaisPorFaixaDePreco(double valorMinimo, double valorMaximo) {
        Cotacao[] auxiliar = new Cotacao[qtdCotacoes];
        int qtdAuxiliar = 0;

        for (int i = 0; i < qtdCotacoes; i++) {
            double valor = cotacoes[i].valorTotalDaCotacao();
            if ( (cotacoes[i].getProduto() instanceof ProdutoNacional) &&
                    (valor >= valorMinimo) && (valor <= valorMaximo)) {
                auxiliar[qtdAuxiliar] = cotacoes[i];
                qtdAuxiliar++;
            }
        }

        if (qtdAuxiliar > 0)
            return auxiliar;
        else
            return null;
    }
}
