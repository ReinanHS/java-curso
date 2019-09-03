package Provas.MineProva;

import java.util.Random;

public class Produto {
    // Atributos
    private int Id;
    private String Nome;
    private String Descricao;
    private Double ValorUnitario = 0.0;
    private String UnidadeMedida;

    // Métodos Especiais
    public Produto(){
        // Caso não seja definido pelo construct um id para o produto isso sera feito automaticamente
        this.Id = (new Random().nextInt(10)+1) * (new Random().nextInt(10)+1);
    }

    public Produto(int id) {
        this.Id = id;
    }

    public Produto(String nome, String descricao, Double valorUnitario, String unidadeMedida) {
        this.Id = (new Random().nextInt(10)+1) * (new Random().nextInt(10)+1);
        this.Nome = nome;
        this.Descricao = descricao;
        this.ValorUnitario = valorUnitario;
        this.UnidadeMedida = unidadeMedida;
    }

    public Produto(int id, String nome, String descricao, Double valorUnitario, String unidadeMedida) {
        this.Id = id;
        this.Nome = nome;
        this.Descricao = descricao;
        this.ValorUnitario = valorUnitario;
        this.UnidadeMedida = unidadeMedida;
    }

    // Métados Especiais Gets e Sets

    public int getId() { return this.Id; }

    public void setId(int id) { this.Id = id; }

    public String getNome() { return this.Nome; }

    public void setNome(String nome) { this.Nome = nome; }

    public String getDescricao() { return this.Descricao; }

    public void setDescricao(String descricao) { this.Descricao = descricao; }

    public Double getValorUnitario() { return this.ValorUnitario; }

    public void setValorUnitario(Double valorUnitario) { this.ValorUnitario = valorUnitario; }

    public String getUnidadeMedida() { return this.UnidadeMedida; }

    public void setUnidadeMedida(String unidadeMedida) { this.UnidadeMedida = unidadeMedida; }

    @Override
    public String toString() {
        return "Produto {" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", Valor Unitario=" + ValorUnitario +
                ", Unidade De Medida='" + UnidadeMedida + '\'' +
                '}';
    }

    // Métados
}
