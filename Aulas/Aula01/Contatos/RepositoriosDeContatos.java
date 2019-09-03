package Aulas.Aula01.Contatos;

import javax.swing.*;

public class RepositoriosDeContatos implements Repositorios {

    public Contato Contatos[];

    public void Adicionar(int index){

        Contato contato = new Contato();

        contato.setNome( JOptionPane.showInputDialog(null, "Digite um nome:") );
        contato.setIdade( Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um idade:")) );
        contato.setTelefone( Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um idade:")) );

        this.Contatos[index] = contato;

        JOptionPane.showInputDialog(null, "Contato cadastrado com sucesso!");
    }
    public void Buscar(String busca){

        String Listagem = "";
        boolean achou = false;

        for (int i = 0; i < this.Contatos.length; i++) {
            if( this.Contatos[i].getNome().equals(busca) || this.Contatos[i].getTelefone() == Integer.parseInt(busca) ){
                Listagem += "\nNome:"+this.Contatos[i].getNome();
                Listagem += "\nIdade:"+this.Contatos[i].getIdade();
                Listagem += "\nTelefone:"+this.Contatos[i].getTelefone();
                Listagem += "\n\n";

                achou = true;
            }
        }

        if (!achou) JOptionPane.showInputDialog(null, "N�o foi encontrado o contato!");
        else JOptionPane.showInputDialog(null, Listagem);
    }
    public void Listar(int min, int max){
        String Listagem = "";

        for (int i = 0; i < this.Contatos.length; i++) {
            if(this.Contatos[i].getIdade() >= min && this.Contatos[i].getIdade() <= max){
                Listagem += "\nNome:"+this.Contatos[i].getNome();
                Listagem += "\nIdade:"+this.Contatos[i].getIdade();
                Listagem += "\nTelefone:"+this.Contatos[i].getTelefone();
                Listagem += "\n\n";
            }
        }

        JOptionPane.showInputDialog(null, Listagem);
    }
    public void Listar(){
        String Listagem = "";

        for (int i = 0; i < this.Contatos.length; i++) {
            Listagem += "\nNome:"+this.Contatos[i].getNome();
            Listagem += "\nIdade:"+this.Contatos[i].getIdade();
            Listagem += "\nTelefone:"+this.Contatos[i].getTelefone();
            Listagem += "\n\n";
        }

        JOptionPane.showInputDialog(null, Listagem);
    }
    public void Remover(String busca){
        boolean achou = false;
        int total = 0;
        int limit = this.Contatos.length;

        for (int i = 0; i < limit; i++) {
            if( this.Contatos[i].getNome().equals(busca) || this.Contatos[i].getTelefone() == Integer.parseInt(busca) || this.Contatos[i].getIdade() == Integer.parseInt(busca)  ){
                achou = true;
                total++;
                limit--;

                this.Contatos[i] = this.Contatos[limit];

            }
        }

        if (!achou) JOptionPane.showInputDialog(null, "N�o foi encontrado o contato para ser deletado!");
    }
}
