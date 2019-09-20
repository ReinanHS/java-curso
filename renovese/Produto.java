package renovese;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private double valorUnitario;
    private String unidadeDeMedida;

    public Produto(int id, String nome, String descricao, double valorUnitario, String unidadeDeMedida) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public int getId() {
        return id;
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

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    @Override
    public String toString() {
        return "Produto [" + id + ", " + nome + ", " + descricao +
                ", " + valorUnitario + ", " + unidadeDeMedida + "]";
    }
}
