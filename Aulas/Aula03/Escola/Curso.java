package Aulas.Aula03.Escola;

import java.util.Arrays;

public class Curso {
    public String codigo;
    public String nome;
    public String descricao;
    public String coordenador;
    public Professor[] docentes;

    public void informarDados(String codigo, String nome, String descricao, String coordenador, Professor[] docentes) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.coordenador = coordenador;
        this.docentes = docentes;
    }

    public void definirCoordenador(Professor prof){ this.coordenador = prof.nome; }

    public boolean addDocentes(Professor prof){

        Professor NovosProfessores[] = new Professor[this.docentes.length+1];

        for (int i = 0; i < this.docentes.length ; i++) {
            NovosProfessores[i] = this.docentes[i];
        }

        NovosProfessores[this.docentes.length] = prof;

        this.docentes = NovosProfessores;

        return true;
    }

    public void imprimirDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", coordenador='" + coordenador + '\'' +
                ", docentes=" + Arrays.toString(docentes) +
                '}';
    }
}
