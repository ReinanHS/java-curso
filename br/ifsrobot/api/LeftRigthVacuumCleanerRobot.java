package br.ifsrobot.api;
// Classe concreta que representa um robô aspirador de pó capaz de navegar no ambiente no sentido da esquerda para
//direita (colunas) e de cima para baixo (linhas), identificar se o local está sujo e limpá-lo, se for necessário.
public class LeftRigthVacuumCleanerRobot extends AbsVacuumCleanerRobot{

    // Construtor com o ambiente em que o robô aspirador de pó navegará e limpará.
    public LeftRigthVacuumCleanerRobot(Environment environment){
        super(environment);
    }
    // Métodos
    public Position move(){
        if(this.environment.getWidth() > this.currentPosition.getRow()){
            return new Position(this.currentPosition.getCol(), this.currentPosition.getRow()+1);
        }else if(this.environment.getWidth() == this.currentPosition.getRow() && this.environment.getLength() > this.currentPosition.getCol() ){
            return new Position(this.currentPosition.getCol()+1, 0);
        }

        return new Position(this.currentPosition.getCol(), this.currentPosition.getRow());
    }
}
