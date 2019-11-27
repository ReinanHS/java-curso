package br.ifsrobot.api;
// Classe concreta que representa um rob� aspirador de p� capaz de navegar no ambiente no sentido da esquerda para
//direita (colunas) e de cima para baixo (linhas), identificar se o local est� sujo e limp�-lo, se for necess�rio.
public class LeftRigthVacuumCleanerRobot extends AbsVacuumCleanerRobot{

    // Construtor com o ambiente em que o rob� aspirador de p� navegar� e limpar�.
    public LeftRigthVacuumCleanerRobot(Environment environment){
        super(environment);
    }
    // M�todos
    public Position move(){
        if(this.environment.getWidth() > this.currentPosition.getRow()){
            return new Position(this.currentPosition.getCol(), this.currentPosition.getRow()+1);
        }else if(this.environment.getWidth() == this.currentPosition.getRow() && this.environment.getLength() > this.currentPosition.getCol() ){
            return new Position(this.currentPosition.getCol()+1, 0);
        }

        return new Position(this.currentPosition.getCol(), this.currentPosition.getRow());
    }
}
