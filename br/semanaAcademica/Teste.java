package br.semanaAcademica;

public class Teste {
    public static void main(String[] args) {
        Alunos reinan = new Alunos("2019004705","Reinan Gabriel", 1,"BSI", "1");
        Alunos lucas = new Alunos("2019004706","Lucas Santos", 1,"BSI", "1");
        Alunos davi = new Alunos("2019004707","Davi Souza", 1,"BSI", "1");
        Alunos joao = new Alunos("2019004708","João Paulo", 1,"BSI", "1");

        Professor fabio = new Professor("201058752", "Fabio Santos", 5, "BSI", "201365478","IFS",2145597);

        Evento evento1 = new Evento("Evento 1", "Não tem", 2,"IFS", "10:30 Noite", 60);

        evento1.cadastroParticipantes(reinan);
        evento1.cadastroParticipantes(lucas);
        evento1.cadastroParticipantes(davi);
    }
}
