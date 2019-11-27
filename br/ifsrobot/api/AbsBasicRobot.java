package br.ifsrobot.api;
// Classe abstrata que representa um rob� capaz de navegar no ambiente.
public abstract class AbsBasicRobot implements IRobot {
    // Atributos
    // Atributo que armazena o ambiente do rob�.
    protected Environment environment;
    // Atributo que armazena posi��o atual do rob�.
    protected Position currentPosition = new Position(0,0);
    // Atributo que armazena posi��o inicial (origem) do rob�.
    protected Position initialPosition = new Position(0,0);
    // Atributo que armazena posi��o final (destino) do rob�.
    protected Position finalPosition = new Position(0,0);

    // Construtores

    public AbsBasicRobot(Environment environment){
        this.environment = environment;
    }

    // M�todos
    // M�todo para definir a posi��o inicial do rob�. O m�todo deve lan�ar um exce��o
    //do tipo RobotException com a mensagem "Posi��o inicial inv�lida." caso a
    //posi��o informada esteja fora dos limites do ambiente.
    public void setStartPosition(Position position) throws RobotException{
        try{

            if( position.getCol() <= this.environment.getLength() && position.getRow() <= this.environment.getWidth() ){
                this.initialPosition = position;
            }else{
                throw new RobotException("Posi��o inicial inv�lida. caso a posi��o informada esteja fora dos limites do ambiente.");
            }

            // Mudar isso depois
        }catch (NullPointerException ex){
            throw new RobotException("Posi��o inicial n�o iniciada");
        }
    }
    // M�todo para definir a posi��o final do rob�. O m�todo deve lan�ar um exce��o
    //do tipo RobotException com a mensagem "Posi��o final inv�lida." caso a
    //posi��o informada esteja fora dos limites do ambiente.
    public void setFinalPosition(Position position) throws RobotException{
        try{

            if( position.getCol() <= this.environment.getLength() && position.getRow() <= this.environment.getWidth() ){
                this.finalPosition = position;
            }else{
                throw new RobotException("Posi��o final inv�lida. caso a posi��o informada esteja fora dos limites do ambiente.");
            }

            // Mudar isso depois
        }catch (NullPointerException ex){
            throw new RobotException("Posi��o final n�o iniciada");
        }
    }
//    M�todo que retorna o ambiente do rob�.
    public Environment getEnvironment(){
        return this.environment;
    }
//    M�todo que retorna a posi��o inicial do rob�.
    public Position getInitialPosition(){
        return this.initialPosition;
    }
//    M�todo que retorna a posi��o final do rob�.
    public Position getFinalPosition(){
        return this.finalPosition;
    }
//    M�todo que retorna a posi��o atual do rob�.
    public Position getCurrentPosition(){
        return this.currentPosition;

    }
//  M�todo que imprime a posi��o do rob� no formato "\nO rob� est� na posi��o
//
//   "+<posi��o>+"."
    public void printPosition(){
        System.out.println("O rob� est� na posi��o ["+this.getCurrentPosition().getCol()+"]"+this.getCurrentPosition().getRow());
    }
}
