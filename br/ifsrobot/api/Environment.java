package br.ifsrobot.api;

import java.util.Arrays;

// Classe que representa um ambiente. O ambiente � representado como uma matriz de char de duas dimens�es.
public class Environment {
    // Atributos
    // Atributo que representa o ambiente. Cada posi��o do ambiente pode conter o
    //valor ' ' representando que o local est� limpo ou 'S' quando o local estiver sujo.
    private char[][] environment;

    // Construtor com um ambiente previamente instanciado.
    public Environment(char[][] environment){
        this.environment = environment;
    }

    // Construtor que inicializa um ambiente totalmente limpo com a largura (width) e
    //comprimento (length) informados.
    public Environment(int width, int length){
        this.environment = new char[length][width];
    }

    // M�todos

    // Retorna o valor do ambiente na posi��o informada.
    public char getValue(Position position){
        return this.environment[position.getCol()][position.getRow()];
    }
    // Set posi��o
    public void setValue(char valor, Position position){
        this.environment[position.getCol()][position.getRow()] = valor;
    }
    // Retorna a largura do ambiente.
    public int getWidth(){
        return this.environment.length;
    }
    //
    public int getLength(){
        return this.environment[0].length;
    }
    // M�todo que define o valor na posi��o informada do ambiente.
    public void setValue(Position position, char value){
        this.environment[position.getCol()][position.getRow()] = value;
    }
    // M�todo que imprime o estado atual do ambiente no formato ilustrado abaixo,
    public void printEnvironment(){
        for (int i = 0; i < this.environment.length; i++) {

            String str = "";

            for (int j = 0; j < this.environment[i].length; j++) {
                str += this.environment[i][j]+"| ";
            }

            System.out.println(str);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Environment){

            Environment novoObj = ((Environment) obj);

            return ((novoObj.environment.length == this.environment.length) && ( novoObj.environment[0].length == this.environment[0].length ));

        }

        return false;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "environment=" + Arrays.toString(environment) +
                '}';
    }
}
