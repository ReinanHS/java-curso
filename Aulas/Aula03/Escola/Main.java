package Aulas.Aula03.Escola;

public class Main {
    public static void main(String[] args) {
        // Professoes
        Professor lucas = new Professor();
        Professor reinan = new Professor();
        Professor gabriel = new Professor();
        Professor davi = new Professor();

        Curso matematica = new Curso();
        Curso calculo = new Curso();
        Curso ingles = new Curso();
        Curso etica = new Curso();

        lucas.informarDados("201900478", "Lucas Santos", "254879654", "Matematica", "lucas@ifs.edu.br", matematica);
        reinan.informarDados("201950475", "Reinan Gabriel", "254879654", "CÁLCULO I", "reinan@ifs.edu.br", etica);
        gabriel.informarDados("201500262", "Gabriel Souza", "254879654", "INGLÊS INSTRUMENTAL", "gabriel@ifs.edu.br", etica);
        davi.informarDados("201300118", "Davi Pato", "254879654", "Etica e Sociedade", "davi@ifs.edu.br", calculo);

        Aluno jean = new Aluno();
        jean.imprimirDados("201904586", "Jean Santos", "254879654", "jean@ifs.edu.br", matematica);

        Aluno jose = new Aluno();
        jose.imprimirDados("201904586", "Jose Santos", "254879654", "jean@ifs.edu.br", matematica);

        Aluno leandro = new Aluno();
        leandro.imprimirDados("201904586", "Leando Santos", "254879654", "jean@ifs.edu.br", matematica);

        Aluno paulo = new Aluno();
        paulo.imprimirDados("201904586", "Paulo Santos", "254879654", "jean@ifs.edu.br", matematica);

        Aluno luiz = new Aluno();
        luiz.imprimirDados("201904586", "Luiz Santos", "254879654", "jean@ifs.edu.br", matematica);

        Aluno ze = new Aluno();
        ze.imprimirDados("201904586", "Ze Santos", "254879654", "jean@ifs.edu.br", matematica);
    }
}
