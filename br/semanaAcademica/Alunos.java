package br.semanaAcademica;

import java.util.Arrays;

public class Alunos extends Participante{
private String periodo;
private Materia materias[];
private int qtdMateria;

    public Alunos(String matricula, String nome, int nivelEscolar, String curso, String periodo) {
        super(matricula, nome, nivelEscolar, curso);
        this.periodo = periodo;

    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    public boolean addMateria(Materia materia){
        try{

            Materia materias[] = new Materia[this.materias.length+1];
            int qtd = 0;

            for (Materia x: this.materias) {
                materias[qtd] = x;
                qtd++;
            }

            materias[this.materias.length] = materia;

            this.materias = materias;

            return true;

        }catch(NullPointerException ex){
            Materia materias[] = new Materia[1];
            materias[0] = materia;

            this.materias = materias;

            return true;
        }
    }
    public boolean removerMateria(Materia materia){
        try{

            if(this.materias.length > 0){
                Materia materias[] = new Materia[this.materias.length-1];
                int qtd = 0;

                for (Materia x: this.materias ) {
                    if(!x.equals(materia)){
                        materias[qtd] = x;
                        qtd++;
                    }
                }

                this.materias = materias;
                return true;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }
    public boolean removerMateriaPeloId(int codigo){
        try{

            if(this.materias.length > 0){

                for (Materia x: this.materias ) {
                    if(x.getCodigo() == codigo){
                        return this.removerMateria(x);
                    }
                }

                return false;
            }

            return false;

        }catch (NullPointerException ex){
            return false;
        }
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "periodo='" + periodo + '\'' +
                ", materias=" + Arrays.toString(materias) +
                ", qtdMateria=" + qtdMateria +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", nivelEscolar=" + nivelEscolar +
                ", curso='" + curso + '\'' +
                '}';
    }
}
