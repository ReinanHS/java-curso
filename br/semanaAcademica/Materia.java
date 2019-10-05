package br.semanaAcademica;

public class Materia {

    private int codigo;
    private String nome;
    private int quantitativo;

    public Materia(int codigo, String nome, int quantitativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantitativo = quantitativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantitativo() {
        return quantitativo;
    }

    public void setQuantitativo(int quantitativo) {
        this.quantitativo = quantitativo;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", quantitativo=" + quantitativo +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Materia){

            Materia novoObj = (Materia) obj;

            if( novoObj.getNome().equals(this.getNome()) ){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
}
