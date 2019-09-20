package Tests.Atividades.Herenca;

public class Programador extends Empregado {
    /*
        IFS - Instituto Federal Sergipe, Campus Lagarto
        PROF: Gilson Pereira dos Santos J�nio
        DATA: 20/09/2019
    	ALUNO: Reinan Gabriel Dos Santos Souza
    */

    // Atributos
    private String linguagem;
    // M�tados Especiais

    public Programador(int id, String nome, float salario, String linguagem) {
        super(id, nome, salario);
        this.linguagem = linguagem;
    }

    // M�tados Especiais Gets e Sets

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    // M�tados
    public String toString(){
        return "Programador{ "+ super.toString() +" ,"+ this.getLinguagem() +'}';
    }
}
